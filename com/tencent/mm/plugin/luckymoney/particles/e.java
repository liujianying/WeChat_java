package com.tencent.mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;

public final class e {
    private static final Paint kSJ;
    private static Interpolator kSK;

    static {
        Paint paint = new Paint();
        kSJ = paint;
        paint.setStyle(Style.FILL);
    }

    public static Interpolator bbf() {
        if (kSK == null) {
            kSK = new 1();
        }
        return kSK;
    }
}
