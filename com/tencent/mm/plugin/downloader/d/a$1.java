package com.tencent.mm.plugin.downloader.d;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKContentType;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class a$1 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ a icL;

    a$1(a aVar, a aVar2) {
        this.icL = aVar;
        this.ibG = aVar2;
    }

    public final void run() {
        int startDownloadTask;
        Exception e;
        try {
            startDownloadTask = a.a(this.icL).startDownloadTask(this.ibG.field_downloadUrl, this.ibG.field_secondaryUrl, this.ibG.field_fileSize, 0, TMAssistantDownloadSDKContentType.CONTENT_TYPE_OTHERS, ac.ce(this.ibG.field_downloadUrl), this.ibG.field_autoDownload, this.icL.icI);
            TMAssistantDownloadTaskInfo downloadTaskState;
            switch (startDownloadTask) {
                case 0:
                    try {
                        downloadTaskState = a.a(this.icL).getDownloadTaskState(this.ibG.field_downloadUrl);
                        x.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", new Object[]{this.ibG.field_downloadUrl, downloadTaskState.mSavePath, Integer.valueOf(e.cm(downloadTaskState.mSavePath)), Long.valueOf(downloadTaskState.mReceiveDataLen)});
                        this.ibG.field_startSize = downloadTaskState.mReceiveDataLen;
                        this.ibG.field_filePath = downloadTaskState.mSavePath;
                        this.ibG.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                        this.ibG.field_totalSize = downloadTaskState.mTotalDataLen;
                        c.e(this.ibG);
                        this.icL.icH.add(Long.valueOf(this.ibG.field_downloadId));
                        a.a(this.icL, this.ibG.field_downloadUrl, downloadTaskState.mState, 0, true);
                        this.icL.ibT.i(this.ibG.field_downloadId, downloadTaskState.mSavePath);
                        x.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[]{Long.valueOf(this.ibG.field_downloadId), this.ibG.field_downloadUrl, this.ibG.field_filePath});
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        break;
                    }
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
                    c.e(this.ibG);
                    this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
                    return;
                case 4:
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                    downloadTaskState = a.a(this.icL).getDownloadTaskState(this.ibG.field_downloadUrl);
                    this.ibG.field_filePath = downloadTaskState.mSavePath;
                    this.ibG.field_startSize = downloadTaskState.mReceiveDataLen;
                    this.ibG.field_downloadedSize = downloadTaskState.mReceiveDataLen;
                    this.ibG.field_totalSize = downloadTaskState.mTotalDataLen;
                    c.e(this.ibG);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.icm, 1);
                    intent.setClass(this.icL.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, this.ibG.field_downloadId);
                    try {
                        this.icL.mContext.startService(intent);
                    } catch (Exception e3) {
                        x.e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
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
        } catch (Exception e4) {
            e3 = e4;
            startDownloadTask = -1;
        }
        x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{e3.getMessage()});
        this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibd;
        this.ibG.field_status = 4;
        c.e(this.ibG);
        x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(startDownloadTask), this.ibG.field_downloadUrl});
        this.icL.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibd, false);
    }
}
