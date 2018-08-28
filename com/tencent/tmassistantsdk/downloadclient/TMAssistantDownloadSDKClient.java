package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback$Stub;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue;
    protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList;

    public TMAssistantDownloadSDKClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        this.mListenerReferenceQueue = new ReferenceQueue();
        this.mWeakListenerArrayList = new ArrayList();
        this.mServiceCallback = new ITMAssistantDownloadSDKServiceCallback$Stub() {
            public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ", errorcode" + i2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, i, i2, str3, z, z2);
                }
            }

            public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2) {
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",totalLen:" + j2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, j, j2);
                }
            }
        };
    }

    public synchronized TMAssistantDownloadTaskInfo getDownloadTaskState(String str) {
        TMAssistantDownloadTaskInfo downloadTaskInfo;
        TMLog.i(TAG, "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            downloadTaskInfo = iTMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, str);
        } else {
            super.initTMAssistantDownloadSDK();
            downloadTaskInfo = null;
        }
        return downloadTaskInfo;
    }

    public synchronized int startDownloadTask(String str, String str2) {
        return startDownloadTask(str, "", 0, 0, str2, null, true, null);
    }

    public synchronized int startDownloadTask(String str, String str2, Map<String, String> map) {
        return startDownloadTask(str, "", 0, 0, str2, null, true, map);
    }

    public synchronized int startDownloadTask(String str, String str2, String str3) {
        return startDownloadTask(str, "", 0, 0, str2, str3, true, null);
    }

    public synchronized int startDownloadTask(String str, String str2, long j, int i, String str3, String str4, boolean z, Map<String, String> map) {
        int startDownloadTask;
        TMLog.i(TAG, "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + str + ",contentType:" + str3);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        if (str3.equals("resource/tm.android.unknown") && TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
            startDownloadTask = iTMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, str, str2, j, 0, str3, str4, map);
        } else {
            TMLog.i(TAG, "startDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            startDownloadTask = 0;
        }
        return startDownloadTask;
    }

    public synchronized void pauseDownloadTask(String str) {
        TMLog.i(TAG, "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, str);
        } else {
            TMLog.i(TAG, "pauseDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
        }
    }

    public synchronized void cancelDownloadTask(String str) {
        TMLog.i(TAG, "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, str);
        } else {
            TMLog.i(TAG, "cancelDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean registerDownloadTaskListener(com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener r5) {
        /*
        r4 = this;
        r1 = 1;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0007;
    L_0x0004:
        r0 = 0;
    L_0x0005:
        monitor-exit(r4);
        return r0;
    L_0x0007:
        r0 = r4.mListenerReferenceQueue;	 Catch:{ all -> 0x001e }
        r0 = r0.poll();	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x0021;
    L_0x000f:
        r2 = "TMAssistantDownloadSDKClient";
        r3 = "registerDownloadTaskListener removed listener!!!!";
        com.tencent.tmassistantsdk.util.TMLog.i(r2, r3);	 Catch:{ all -> 0x001e }
        r2 = r4.mWeakListenerArrayList;	 Catch:{ all -> 0x001e }
        r2.remove(r0);	 Catch:{ all -> 0x001e }
        goto L_0x0007;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0021:
        r0 = r4.mWeakListenerArrayList;	 Catch:{ all -> 0x001e }
        r2 = r0.iterator();	 Catch:{ all -> 0x001e }
    L_0x0027:
        r0 = r2.hasNext();	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x003d;
    L_0x002d:
        r0 = r2.next();	 Catch:{ all -> 0x001e }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x001e }
        r0 = r0.get();	 Catch:{ all -> 0x001e }
        r0 = (com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener) r0;	 Catch:{ all -> 0x001e }
        if (r0 != r5) goto L_0x0027;
    L_0x003b:
        r0 = r1;
        goto L_0x0005;
    L_0x003d:
        r0 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x001e }
        r2 = r4.mListenerReferenceQueue;	 Catch:{ all -> 0x001e }
        r0.<init>(r5, r2);	 Catch:{ all -> 0x001e }
        r2 = r4.mWeakListenerArrayList;	 Catch:{ all -> 0x001e }
        r2.add(r0);	 Catch:{ all -> 0x001e }
        r0 = r1;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient.registerDownloadTaskListener(com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener):boolean");
    }

    public synchronized boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        if (iTMAssistantDownloadSDKClientListener == null) {
            z = false;
        } else {
            Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (((ITMAssistantDownloadSDKClientListener) weakReference.get()) == iTMAssistantDownloadSDKClientListener) {
                    this.mWeakListenerArrayList.remove(weakReference);
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    protected void onDownloadSDKServiceInvalid() {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, (ITMAssistantDownloadSDKClientListener) ((WeakReference) it.next()).get());
        }
    }

    protected void stubAsInterface(IBinder iBinder) {
        this.mServiceInterface = Stub.asInterface(iBinder);
    }

    protected void registerServiceCallback() {
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
    }

    protected Intent getBindServiceIntent() {
        return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
    }

    protected void unRegisterServiceCallback() {
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
    }

    public static String about() {
        return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
    }
}
