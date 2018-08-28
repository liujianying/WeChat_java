package com.tencent.mm.platformtools;

import android.content.Context;

public class c$a {
    public static int b(Context context, float f) {
        g gVar = new g();
        return Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
    }
}
