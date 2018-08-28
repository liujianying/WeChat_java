package com.tencent.mm.ui;

import android.content.Context;
import android.util.SparseIntArray;

public final class ap {
    private static float density = -1.0f;
    private static SparseIntArray sCy = new SparseIntArray();
    private static float scale = 0.0f;

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int ae(Context context, int i) {
        if (context == null) {
            ao.v("get dimension pixel size, resId %d, but context is null" + i, new Object[0]);
            return 0;
        }
        int i2 = sCy.get(i, 0);
        if (i2 != 0) {
            return i2;
        }
        i2 = context.getResources().getDimensionPixelSize(i);
        sCy.put(i, i2);
        return i2;
    }

    public static float getDensity(Context context) {
        if (context != null && density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static float fe(Context context) {
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return scale;
    }
}
