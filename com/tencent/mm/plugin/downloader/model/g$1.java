package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ e icv;
    final /* synthetic */ g icw;

    g$1(g gVar, e eVar, a aVar) {
        this.icw = gVar;
        this.icv = eVar;
        this.ibG = aVar;
    }

    public final void run() {
        if (this.icv.icf) {
            this.ibG.field_md5 = f.yV(this.ibG.field_downloadUrl);
        }
        long g = this.icw.g(this.ibG);
        if (g > 0) {
            this.ibG.field_sysDownloadId = g;
            this.ibG.field_status = 1;
            c.e(this.ibG);
            this.icw.ibT.i(this.ibG.field_downloadId, this.ibG.field_filePath);
            d.aCU();
            if (d.cu(this.ibG.field_downloadId)) {
                d.aCU();
                d.q(this.ibG.field_downloadId, g);
            }
            this.icw.icu.add(Long.valueOf(this.ibG.field_downloadId));
            if (this.icw.eOf.ciq()) {
                this.icw.eOf.J(100, 100);
            }
            x.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[]{Long.valueOf(this.ibG.field_downloadId), this.ibG.field_downloadUrl, this.ibG.field_filePath});
            return;
        }
        this.ibG.field_status = 4;
        c.e(this.ibG);
        this.icw.ibT.c(this.ibG.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibr, false);
        x.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
    }
}
