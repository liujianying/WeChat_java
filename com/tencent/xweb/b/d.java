package com.tencent.xweb.b;

import org.xwalk.core.Log;

public final class d implements b {
    public static a vAW = null;
    public c vAX = null;

    public static void a(a aVar) {
        Log.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        vAW = aVar;
    }

    public static boolean isValid() {
        return vAW != null;
    }

    public final void u(String str, String str2, boolean z) {
        Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.vAX.onTaskSucc(str, str2, z);
    }

    public final void s(String str, int i, boolean z) {
        Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.vAX.onTaskFail(str, i, z);
    }

    public final void y(String str, long j, long j2) {
        Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        this.vAX.onProgressChange(str, j, j2);
    }
}
