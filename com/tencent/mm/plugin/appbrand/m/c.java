package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    b gsH;
    public com.tencent.mm.sdk.b.c gsI;
    public com.tencent.mm.sdk.b.c gsJ;
    public com.tencent.mm.sdk.b.c gsK;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.gsK = new 3(this);
        this.gsH = new b();
        this.gsI = new 1(this);
        this.gsJ = new com.tencent.mm.sdk.b.c<hx>() {
            {
                this.sFo = hx.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                ((hx) bVar).bRs.bRt = c.this.gsH.aIs;
                return true;
            }
        };
    }

    public final void prepare() {
        a.sFg.b(this.gsI);
        a.sFg.b(this.gsJ);
        this.gsK.cht();
        refresh();
        File file = new File(this.gsH.fjY);
        x.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[]{Integer.valueOf(this.gsH.aIs), Integer.valueOf(65900182)});
        if (this.gsH.aIs < 65900182 && d(file, "wxa_fts_template.zip")) {
            refresh();
        }
    }

    final void refresh() {
        this.gsH.aIs = ((f) g.l(f.class)).adQ();
        this.gsH.fjY = ((f) g.l(f.class)).adP();
    }

    private static boolean d(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        boolean bc = ((f) g.l(f.class)).bc(absolutePath, str);
        if (bc) {
            if (bi.fR(absolutePath, file3.getParent()) < 0) {
                x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[]{Integer.valueOf(bi.fR(absolutePath, file3.getParent())), absolutePath, file3.getParent()});
                return false;
            }
            x.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[]{file3.getAbsolutePath()});
            return bc;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[]{file3.getAbsolutePath()});
        return bc;
    }

    static boolean f(File file, File file2) {
        e.k(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (bi.fR(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[]{Integer.valueOf(bi.fR(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath()});
            return false;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[]{file2.getAbsolutePath()});
        return true;
    }
}
