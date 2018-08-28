package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w$b;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements w {
    private String mPicUrl = null;

    public o(String str) {
        this.mPicUrl = str;
    }

    public final String Vv() {
        return c.brY().eq(this.mPicUrl, "@S");
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
                x.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
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
