package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$3 extends c<ix> {
    final /* synthetic */ c gsL;

    c$3(c cVar) {
        this.gsL = cVar;
        this.sFo = ix.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ix ixVar = (ix) bVar;
        if (ixVar.bSA.bIC == 40 && ixVar.bSA.bID == 1) {
            File file = new File(ixVar.bSA.filePath);
            f fVar = (f) g.l(f.class);
            if (file.exists()) {
                x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                File file2 = new File(fVar.adP(), "temp");
                File file3 = new File(file2, "wxa_fts_template.zip");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                int intValue = bi.fR(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0 ? Integer.valueOf(fVar.A(new File(file2, "config.conf")).getProperty("version", "0")).intValue() : 65900182;
                e.k(file2);
                x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.gsL.gsH.aIs), Integer.valueOf(intValue)});
                if (c.f(file, new File(this.gsL.gsH.fjY))) {
                    this.gsL.refresh();
                } else {
                    x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                }
            } else {
                x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
