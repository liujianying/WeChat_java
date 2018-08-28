package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements w {
    private c$a nbO = null;
    private String thumburl = "";

    public b(c$a c_a) {
        this.nbO = c_a;
    }

    public b(String str) {
        this.thumburl = str;
    }

    public final String Vv() {
        if (this.nbO != null && this.nbO.field_thumburl != null) {
            return m.eq(this.nbO.field_thumburl, "@S");
        }
        if (this.thumburl != null) {
            return m.eq(this.thumburl, "@S");
        }
        return "";
    }

    public final String Vw() {
        if (this.nbO == null || this.nbO.field_thumburl == null) {
            return this.thumburl;
        }
        return this.nbO.field_thumburl;
    }

    public final String Vx() {
        return Vw() + "_tv";
    }

    public final String getCacheKey() {
        return Vw() + "_tv";
    }

    public final boolean Vy() {
        return false;
    }

    public final boolean Vz() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.evZ == aVar) {
            try {
                c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
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

    public final Bitmap VA() {
        if (ad.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.nosdcard_chatting_bg);
    }

    public final com.tencent.mm.platformtools.w.b Vu() {
        return null;
    }
}
