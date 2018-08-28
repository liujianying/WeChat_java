package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.s.e;

public final class a {
    public static int cM(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(e.DefaultActionbarHeightLand);
        }
        return context.getResources().getDimensionPixelSize(e.DefaultActionbarHeightPort);
    }
}
