package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a ibF;
    final /* synthetic */ a ibG;

    a$2(a aVar, a aVar2) {
        this.ibF = aVar;
        this.ibG = aVar2;
    }

    public final void run() {
        int a = com.tencent.mm.plugin.cdndownloader.c.a.aAk().a(a.c(this.ibG));
        x.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[]{Integer.valueOf(a), Long.valueOf(this.ibG.field_downloadId)});
        if (a == 0) {
            this.ibG.field_status = 1;
            c.d(this.ibG);
            this.ibF.ibT.i(this.ibG.field_downloadId, this.ibG.field_filePath);
            a.a(this.ibF, this.ibG.field_downloadUrl, 1, 0, true);
        } else if (a == -2) {
            this.ibG.field_status = 1;
            c.d(this.ibG);
        } else {
            this.ibG.field_status = 4;
            this.ibG.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibg;
            c.d(this.ibG);
            this.ibF.ibT.c(this.ibG.field_downloadId, this.ibG.field_errCode, false);
        }
    }
}
