package com.tencent.mm.plugin.downloader.d;

import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class a$6 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ long ibH;
    final /* synthetic */ a icL;

    a$6(a aVar, a aVar2, long j) {
        this.icL = aVar;
        this.ibG = aVar2;
        this.ibH = j;
    }

    public final void run() {
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.icL).getDownloadTaskState(this.ibG.field_downloadUrl);
            if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                a.a(this.icL).pauseDownloadTask(this.ibG.field_downloadUrl);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[]{Long.valueOf(this.ibH)});
            }
        } catch (Throwable e) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
        }
    }
}
