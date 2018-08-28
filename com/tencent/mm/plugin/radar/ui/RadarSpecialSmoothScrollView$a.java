package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Interpolator;

final class RadarSpecialSmoothScrollView$a implements Interpolator {
    private static final float mlw = mlw;
    public static final a mlx = new a((byte) 0);
    private final float mlv = mlw;

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.mlv + 1.0f)) + this.mlv) * (f2 * f2)) + 1.0f;
    }
}
