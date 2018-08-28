package com.tencent.mm.bq;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.svg.a.a;
import com.tencent.mm.svg.b.b;

public final class c {
    a sCI = new a();

    static {
        com.tencent.mm.compatible.g.a.a(new a());
        b.lp(ad.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
    }

    public final Drawable c(Resources resources, int i) {
        if (this.sCI.d(resources, i)) {
            return a.c(resources, i);
        }
        return null;
    }

    public static void kZ(boolean z) {
        ad.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", z).commit();
        b.lp(z);
    }
}
