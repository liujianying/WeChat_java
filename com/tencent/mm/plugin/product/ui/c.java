package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class c implements w {
    private static final String hwK = (e.bnE + "wallet");
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final b Vu() {
        return null;
    }

    public final String Vv() {
        return JC(this.url);
    }

    public final String Vw() {
        return this.url;
    }

    public final String Vx() {
        return this.url;
    }

    public final String getCacheKey() {
        return this.url;
    }

    public final boolean Vy() {
        return true;
    }

    public final boolean Vz() {
        return false;
    }

    public final Bitmap VA() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.evZ == aVar) {
            try {
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, JC(this.url), false);
            } catch (IOException e) {
                try {
                    File file = new File(hwK);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    x.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, JC(this.url), false);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                    x.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        x.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[]{aVar.toString()});
        return bitmap;
    }

    public final void VB() {
    }

    public final void P(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public static String JC(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{hwK, g.u(str.getBytes())});
    }
}
