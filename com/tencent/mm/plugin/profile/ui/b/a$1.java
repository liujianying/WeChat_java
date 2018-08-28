package com.tencent.mm.plugin.profile.ui.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements w {
    final /* synthetic */ a lZr;

    a$1(a aVar) {
        this.lZr = aVar;
    }

    public final boolean Vz() {
        return false;
    }

    public final boolean Vy() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.evZ == aVar) {
            try {
                c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.UrlDrawable", e, "", new Object[0]);
                x.w("MicroMsg.UrlDrawable", "save bitmap fail");
            }
        }
        x.d("MicroMsg.UrlDrawable", "get bitmap, from %s", new Object[]{aVar.toString()});
        return bitmap;
    }

    public final void VB() {
    }

    public final void P(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final b Vu() {
        return null;
    }

    public final String Vv() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(com.tencent.mm.model.c.Gl()).append(ac.ce(a.a(this.lZr))).toString();
    }

    public final String Vx() {
        return a.a(this.lZr);
    }

    public final Bitmap VA() {
        return null;
    }

    public final String Vw() {
        return a.a(this.lZr);
    }

    public final String getCacheKey() {
        return a.a(this.lZr);
    }
}
