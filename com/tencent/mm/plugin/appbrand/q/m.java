package com.tencent.mm.plugin.appbrand.q;

import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ad;

public final class m {
    private static DisplayMetrics gBr = ad.getContext().getResources().getDisplayMetrics();

    public static int aos() {
        if (gBr == null) {
            return 16;
        }
        return (int) (gBr.density * 16.0f);
    }
}
