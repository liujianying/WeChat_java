package com.tencent.mm.plugin.downloader.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ long ibH;
    final /* synthetic */ j icy;

    j$3(j jVar, a aVar, long j) {
        this.icy = jVar;
        this.ibG = aVar;
        this.ibH = j;
    }

    public final void run() {
        int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(this.ibG.field_downloadUrl);
        x.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: " + resumeHttpMultiSocketDownloadTask);
        this.ibG.field_startTime = System.currentTimeMillis();
        this.ibG.field_startState = b.ibt;
        this.ibG.field_startSize = this.ibG.field_downloadedSize;
        if (resumeHttpMultiSocketDownloadTask == 0) {
            this.ibG.field_status = 1;
            this.ibG.field_errCode = 0;
            c.e(this.ibG);
            this.icy.ibT.j(this.ibH, this.ibG.field_filePath);
            if (this.ibG.field_totalSize != 0) {
                long j = this.ibG.field_downloadedSize;
                j = this.ibG.field_totalSize;
                return;
            }
            return;
        }
        this.ibG.field_status = 4;
        this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibh;
        c.e(this.ibG);
        this.icy.ibT.c(this.ibH, this.ibG.field_errCode, false);
    }
}
