package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements Runnable {
    final /* synthetic */ a ibF;
    final /* synthetic */ a ibG;
    final /* synthetic */ long ibH;

    a$5(a aVar, a aVar2, long j) {
        this.ibF = aVar;
        this.ibG = aVar2;
        this.ibH = j;
    }

    public final void run() {
        long j = 0;
        int b = com.tencent.mm.plugin.cdndownloader.c.a.aAk().b(a.c(this.ibG));
        x.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: " + b);
        this.ibG.field_startTime = System.currentTimeMillis();
        this.ibG.field_startSize = this.ibG.field_downloadedSize;
        this.ibG.field_startState = b.ibt;
        if (b == 0) {
            this.ibG.field_status = 1;
            this.ibG.field_errCode = 0;
            c.e(this.ibG);
            this.ibF.ibT.j(this.ibH, this.ibG.field_filePath);
            if (this.ibG.field_totalSize != 0) {
                j = this.ibG.field_downloadedSize / this.ibG.field_totalSize;
            }
            a.a(this.ibF, this.ibG.field_downloadUrl, 1, (int) j, true);
        } else if (b == -2) {
            this.ibG.field_status = 1;
            this.ibG.field_errCode = 0;
            c.e(this.ibG);
        } else {
            this.ibG.field_status = 4;
            this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibh;
            c.e(this.ibG);
            this.ibF.ibT.c(this.ibH, this.ibG.field_errCode, false);
        }
    }
}
