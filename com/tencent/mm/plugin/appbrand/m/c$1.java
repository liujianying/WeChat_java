package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1 extends c<bc> {
    final /* synthetic */ c gsL;

    c$1(c cVar) {
        this.gsL = cVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 40 && bcVar.bIB.bID == 1) {
            File file = new File(bcVar.bIB.filePath);
            if (file.exists()) {
                x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                File file2 = new File(((f) g.l(f.class)).adP(), "temp");
                File file3 = new File(file2, "wxa_fts_template.zip");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                int fR = bi.fR(file3.getAbsolutePath(), file2.getAbsolutePath());
                int i = 65900182;
                if (fR >= 0) {
                    i = Integer.valueOf(((f) g.l(f.class)).A(new File(file2, "config.conf")).getProperty("version", "0")).intValue();
                }
                e.k(file2);
                if (i > this.gsL.gsH.aIs) {
                    x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.gsL.gsH.aIs), Integer.valueOf(i)});
                    if (c.f(file, new File(this.gsL.gsH.fjY))) {
                        this.gsL.refresh();
                    } else {
                        x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                    }
                } else {
                    x.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.gsL.gsH.aIs), Integer.valueOf(i)});
                }
            } else {
                x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
