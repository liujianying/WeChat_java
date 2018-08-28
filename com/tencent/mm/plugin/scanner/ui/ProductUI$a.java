package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w$b;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.util.n$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class ProductUI$a implements w {
    private n$a mJb;

    public ProductUI$a(n$a n_a) {
        this.mJb = n_a;
    }

    public final String Vv() {
        return c.brY().eq(this.mJb.field_thumburl, "@S");
    }

    public final String Vw() {
        if (this.mJb == null) {
            return "";
        }
        return this.mJb.field_thumburl;
    }

    public final String Vx() {
        if (this.mJb == null) {
            return "";
        }
        return this.mJb.field_thumburl;
    }

    public final String getCacheKey() {
        if (this.mJb == null) {
            return "";
        }
        return this.mJb.field_thumburl;
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
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
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

    public final w$b Vu() {
        return null;
    }
}
