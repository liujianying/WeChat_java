package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool {
    public static final String TAG = "DownloadThreadPool";
    protected static DownloadThreadPool mDownloadThreadPool = null;
    final ArrayList<TaskThread> mDownloadThreadList = new ArrayList();
    final ArrayList<DownloadTask> mExecList = new ArrayList();
    protected final Comparator<DownloadTask> mPriorityQueueComparator = new Comparator<DownloadTask>() {
        public int compare(DownloadTask downloadTask, DownloadTask downloadTask2) {
            if (downloadTask.getPriority() > downloadTask2.getPriority()) {
                return 1;
            }
            if (downloadTask.getPriority() == downloadTask2.getPriority()) {
                return 0;
            }
            return -1;
        }
    };
    final Object mTaskLock = new Object();
    final Object mThreadlock = new Object();
    final PriorityQueue<DownloadTask> mWaitingList = new PriorityQueue(16, this.mPriorityQueueComparator);

    public static DownloadThreadPool getInstance() {
        if (mDownloadThreadPool == null) {
            mDownloadThreadPool = new DownloadThreadPool();
        }
        return mDownloadThreadPool;
    }

    private DownloadThreadPool() {
        int maxTaskNum = DownloadSetting.getInstance().getMaxTaskNum();
        for (int i = 0; i < maxTaskNum; i++) {
            this.mDownloadThreadList.add(new TaskThread(this, i));
        }
    }

    int addDownloadTask(DownloadTask downloadTask) {
        int taskId;
        synchronized (this.mTaskLock) {
            this.mWaitingList.add(downloadTask);
            synchronized (this.mThreadlock) {
                this.mThreadlock.notifyAll();
            }
            taskId = downloadTask.getTaskId();
        }
        return taskId;
    }

    void cancelDownloadTask(int i) {
        synchronized (this.mTaskLock) {
            DownloadTask downloadTask;
            Iterator it = this.mExecList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getTaskId() == i) {
                    downloadTask.cancel();
                    this.mExecList.remove(downloadTask);
                    return;
                }
            }
            it = this.mWaitingList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getTaskId() == i) {
                    downloadTask.cancel();
                    this.mWaitingList.remove(downloadTask);
                    return;
                }
            }
        }
    }

    boolean hasWaitingTask() {
        boolean z;
        synchronized (this.mTaskLock) {
            z = this.mWaitingList.size() > 0;
        }
        return z;
    }

    public DownloadTask getDownloadTask(String str) {
        synchronized (this.mTaskLock) {
            DownloadTask downloadTask;
            Iterator it = this.mExecList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getDownloadURI().equals(str)) {
                    return downloadTask;
                }
            }
            it = this.mWaitingList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getDownloadURI().equals(str)) {
                    return downloadTask;
                }
            }
            return null;
        }
    }
}
