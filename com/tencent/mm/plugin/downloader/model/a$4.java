package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.cdndownloader.c.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ a ibF;
    final /* synthetic */ long ibH;

    a$4(a aVar, long j) {
        this.ibF = aVar;
        this.ibH = j;
    }

    public final void run() {
        x.d("MicroMsg.FileCDNDownloader", JsApiPauseDownloadTask.NAME);
        FileDownloadTaskInfo cm = this.ibF.cm(this.ibH);
        if (cm != null && cm.status == 1) {
            a.aAk().yj(cm.url);
            a.a(this.ibF, cm.url);
            FileDownloadTaskInfo cm2 = this.ibF.cm(this.ibH);
            com.tencent.mm.plugin.downloader.c.a cs = c.cs(this.ibH);
            if (cs != null) {
                cs.field_status = 2;
                cs.field_downloadedSize = cm2.icq;
                c.e(cs);
                Long valueOf = Long.valueOf(bi.a((Long) a.b(this.ibF).get(cm2.url), cs.field_startTime));
                if (valueOf != null) {
                    b.a(cs.field_downloadId, ((((float) (cs.field_downloadedSize - Long.valueOf(bi.a((Long) a.a(this.ibF).get(cm2.url), cs.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) cs.field_downloadedSize) / ((float) cs.field_totalSize)) * 100.0f));
                }
            }
            a.a(this.ibF).remove(cm2.url);
            a.b(this.ibF).remove(cm2.url);
            this.ibF.ibT.cq(this.ibH);
        }
    }
}
