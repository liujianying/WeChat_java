package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.cdndownloader.c.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.platformtools.bi;

class a$3 implements Runnable {
    final /* synthetic */ a ibF;
    final /* synthetic */ long ibH;

    a$3(a aVar, long j) {
        this.ibF = aVar;
        this.ibH = j;
    }

    public final void run() {
        FileDownloadTaskInfo cm = this.ibF.cm(this.ibH);
        if (cm != null) {
            a.aAk().yk(cm.url);
            a.a(this.ibF, cm.url);
            e.deleteFile(cm.path);
            if (cm.status != 5) {
                com.tencent.mm.plugin.downloader.c.a cs = c.cs(this.ibH);
                cs.field_status = 5;
                c.e(cs);
                Long valueOf = Long.valueOf(bi.a((Long) a.b(this.ibF).get(cm.url), cs.field_startTime));
                if (valueOf != null) {
                    b.a(this.ibH, ((((float) (cm.icq - Long.valueOf(bi.a((Long) a.a(this.ibF).get(cm.url), cs.field_startSize)).longValue())) * 1000.0f) / ((float) (System.currentTimeMillis() - valueOf.longValue()))) / 1048576.0f, (int) ((((float) cm.icq) / ((float) cm.gTK)) * 100.0f));
                }
                a.a(this.ibF).remove(cm.url);
                a.b(this.ibF).remove(cm.url);
                this.ibF.ibT.cp(this.ibH);
            }
        }
    }
}
