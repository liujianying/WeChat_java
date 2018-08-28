package com.tencent.mm.model;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class w {
    public a dBc = null;
    boolean dBd = false;
    BlockingQueue<c> dBe = new ArrayBlockingQueue(80);
    public b dBf = null;
    ag handler;

    class c {
        boolean dBk = false;
        String dBl;
        String filename;
        int pos;
        String url;

        public c(String str, String str2, int i, String str3) {
            this.url = str;
            if (q.Pn() && w.this.dBd) {
                this.url = q.lX(this.url);
            }
            this.filename = str2;
            this.pos = i;
            this.dBk = false;
            this.dBl = str3;
        }
    }

    static /* synthetic */ void a(w wVar, long j, long j2) {
        if (wVar.dBd) {
            x.d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            h.mEJ.a(86, j, j2, false);
        }
    }

    public w(boolean z) {
        g.Ek();
        this.handler = new 1(this, g.Em().lnJ.getLooper());
        this.dBc = null;
        this.dBd = z;
        x.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b", new Object[]{Boolean.valueOf(z)});
    }

    public final String c(String str, int i, int i2, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else if (g.Eg().Dx()) {
            str3 = com.tencent.mm.plugin.p.c.Gb() + "/reader_" + i + "_" + com.tencent.mm.a.g.u(str.getBytes()) + ".jpg";
        } else {
            x.i("MicroMsg.GetPicService", "genFileName, account not ready");
            File file = new File(g.Ei().dqo + "/imagecache");
            if (!file.exists()) {
                file.mkdirs();
            }
            str3 = file.getAbsolutePath() + "/reader_" + i + "_" + com.tencent.mm.a.g.u(str.getBytes()) + ".jpg";
        }
        x.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + i + " url:" + str);
        try {
            if (e.cn(str3)) {
                return str3;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e)});
        }
        try {
            this.dBe.add(new c(str, str3, i2, str2));
            if (this.dBc == null || !com.tencent.mm.sdk.f.e.X(this.dBc)) {
                com.tencent.mm.sdk.f.e.remove(this.dBc);
                this.dBc = new a(this);
                com.tencent.mm.sdk.f.e.post(this.dBc, "GetPicService_getPic");
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e2)});
        }
        return null;
    }
}
