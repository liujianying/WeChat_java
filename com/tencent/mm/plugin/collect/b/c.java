package com.tencent.mm.plugin.collect.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements w {
    private b hTJ = new 1(this);
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final String Vv() {
        return com.tencent.mm.plugin.wallet_core.d.b.JC(this.url);
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
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.JC(this.url), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void VB() {
    }

    public final void P(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final b Vu() {
        return this.hTJ;
    }
}
