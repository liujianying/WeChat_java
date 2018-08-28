package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class ap implements w {
    protected String mPicUrl;

    public ap(String str) {
        this.mPicUrl = str;
        File file = new File(e.dgn);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final b Vu() {
        return null;
    }

    public final String Vv() {
        return e.dgn + g.u(this.mPicUrl.getBytes());
    }

    public final String Vw() {
        return this.mPicUrl;
    }

    public final String Vx() {
        return this.mPicUrl.hashCode();
    }

    public final String getCacheKey() {
        return this.mPicUrl.hashCode();
    }

    public final boolean Vy() {
        return true;
    }

    public final boolean Vz() {
        return false;
    }

    public final Bitmap VA() {
        return BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ewa != aVar) {
            try {
                c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
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
}
