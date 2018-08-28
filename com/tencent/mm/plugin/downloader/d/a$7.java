package com.tencent.mm.plugin.downloader.d;

import android.content.Intent;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class a$7 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ long ibH;
    final /* synthetic */ a icL;

    a$7(a aVar, a aVar2, long j) {
        this.icL = aVar;
        this.ibG = aVar2;
        this.ibH = j;
    }

    public final void run() {
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.icL).getDownloadTaskState(this.ibG.field_downloadUrl);
            if (downloadTaskState == null || !(downloadTaskState.mState == 1 || downloadTaskState.mState == 2)) {
                int startDownloadTask = a.a(this.icL).startDownloadTask(this.ibG.field_downloadUrl, this.ibG.field_secondaryUrl, this.ibG.field_fileSize, 0, "resource/tm.android.unknown", ac.ce(this.ibG.field_downloadUrl), this.ibG.field_autoDownload, this.icL.icI);
                TMAssistantDownloadTaskInfo downloadTaskState2 = a.a(this.icL).getDownloadTaskState(this.ibG.field_downloadUrl);
                switch (startDownloadTask) {
                    case 0:
                        this.ibG.field_filePath = downloadTaskState2.mSavePath;
                        this.ibG.field_totalSize = downloadTaskState2.mTotalDataLen;
                        this.ibG.field_status = 1;
                        c.e(this.ibG);
                        this.icL.icH.add(Long.valueOf(this.ibG.field_downloadId));
                        a.a(this.icL, this.ibG.field_downloadUrl, 2, 0, true);
                        this.icL.ibT.j(this.ibG.field_downloadId, this.ibG.field_filePath);
                        x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[]{Long.valueOf(this.ibH)});
                        return;
                    case 1:
                        this.ibG.field_status = 4;
                        this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibn;
                        c.e(this.ibG);
                        this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibn, false);
                        return;
                    case 2:
                        this.ibG.field_status = 4;
                        this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibf;
                        c.e(this.ibG);
                        this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibf, false);
                        return;
                    case 3:
                        this.ibG.field_status = 4;
                        this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
                        c.e(this.ibG);
                        this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                        return;
                    case 4:
                        x.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                        this.ibG.field_filePath = downloadTaskState2.mSavePath;
                        this.ibG.field_startSize = downloadTaskState2.mReceiveDataLen;
                        this.ibG.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                        this.ibG.field_totalSize = downloadTaskState2.mTotalDataLen;
                        c.e(this.ibG);
                        Intent intent = new Intent();
                        intent.putExtra(FileDownloadService.icm, 1);
                        intent.setClass(this.icL.mContext, FileDownloadService.class);
                        intent.putExtra(FileDownloadService.EXTRA_ID, this.ibG.field_downloadId);
                        try {
                            this.icL.mContext.startService(intent);
                        } catch (Exception e) {
                            x.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                        }
                        this.icL.icH.remove(Long.valueOf(this.ibG.field_downloadId));
                        return;
                    case 5:
                        this.ibG.field_status = 1;
                        c.e(this.ibG);
                        this.icL.icH.add(Long.valueOf(this.ibG.field_downloadId));
                        a.a(this.icL, this.ibG.field_downloadUrl, 2, 0, true);
                        return;
                    default:
                        return;
                }
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[]{e.toString()});
                x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                this.ibG.field_status = 4;
                this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibe;
                c.e(this.ibG);
                this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibe, false);
            }
            x.w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
        } catch (Throwable e2) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[]{e2.toString()});
            x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e2, "", new Object[0]);
            this.ibG.field_status = 4;
            this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibe;
            c.e(this.ibG);
            this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibe, false);
        }
    }
}
