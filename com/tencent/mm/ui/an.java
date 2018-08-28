package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public final class an {
    public static int eN(int i, int i2) {
        if (i2 >= 0 && i2 <= 100) {
            return (16777215 & i) | (((int) ((((double) i2) * 0.01d) * 255.0d)) << 24);
        }
        ao.v("alpha must be between 0 and 100", new Object[0]);
        return i;
    }

    public static int n(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i3, b(Color.red(i), alpha2, Color.red(i2), alpha, i3), b(Color.green(i), alpha2, Color.green(i2), alpha, i3), b(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    public static Drawable ao(Context context, int i) {
        Drawable drawable = context.getResources().getDrawable(i);
        drawable.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
        return drawable;
    }

    public static boolean Ec(int i) {
        return 1.0d - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / 255.0d) >= 0.3d;
    }

    private static int b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }
}
