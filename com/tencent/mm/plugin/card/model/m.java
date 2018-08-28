package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class m implements w {
    public static final String hwK = (e.bnE + "card");
    public static final String hwL = (hwK + File.separator + "video");
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    public m(String str) {
        this.mPicUrl = str;
    }

    public final b Vu() {
        return null;
    }

    public final String Vv() {
        return String.format("%s/%s", new Object[]{hwK, g.u(this.mPicUrl.getBytes())});
    }

    public static String xr(String str) {
        return String.format("%s/%s", new Object[]{hwK, g.u(str.getBytes())});
    }

    public final String Vw() {
        return this.mPicUrl;
    }

    public final String Vx() {
        return this.mPicUrl;
    }

    public final String getCacheKey() {
        return this.mPicUrl;
    }

    public final boolean Vy() {
        return true;
    }

    public final boolean Vz() {
        return false;
    }

    public final Bitmap VA() {
        x.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.evZ == aVar) {
            try {
                c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (IOException e) {
                try {
                    File file = new File(Vv());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    x.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e2, "", new Object[0]);
                    x.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        x.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[]{aVar.toString()});
        return bitmap;
    }

    public final void VB() {
    }

    public final void P(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
