package com.tencent.tmassistantsdk.downloadservice;

import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.util.TMLog;

class DownloadThreadPool$TaskThread extends Thread {
    private int mIndex = 0;
    final /* synthetic */ DownloadThreadPool this$0;

    public DownloadThreadPool$TaskThread(DownloadThreadPool downloadThreadPool, int i) {
        this.this$0 = downloadThreadPool;
        this.mIndex = i;
        setName("download_thread_" + this.mIndex);
        start();
    }

    public void run() {
        TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " starts running...");
        while (true) {
            synchronized (this.this$0.mThreadlock) {
                try {
                    TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is waitting...");
                    this.this$0.mThreadlock.wait();
                } catch (Throwable e) {
                    TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
                    x.printErrStackTrace("DownloadThreadPool", e, "", new Object[0]);
                    return;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
                return;
            }
            while (this.this$0.hasWaitingTask()) {
                DownloadTask downloadTask = null;
                synchronized (this.this$0.mTaskLock) {
                    if (this.this$0.mWaitingList.size() > 0) {
                        downloadTask = (DownloadTask) this.this$0.mWaitingList.remove();
                        this.this$0.mExecList.add(downloadTask);
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
                    return;
                }
                if (downloadTask != null) {
                    TMLog.i("DownloadThreadPool", "TaskThread::Run ThreadName: " + getName() + " url: " + downloadTask.getDownloadURI());
                    WakeLock wakeLock = DownloadHelper.getWakeLock();
                    downloadTask.exec(getName());
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                }
                synchronized (this.this$0.mTaskLock) {
                    if (downloadTask != null) {
                        this.this$0.mExecList.remove(downloadTask);
                    }
                }
            }
        }
        while (true) {
        }
    }
}
