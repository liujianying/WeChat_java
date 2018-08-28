package com.tencent.mm.ui.base;

import android.view.animation.Interpolator;

class MMFlipper$c implements Interpolator {
    private float mlv;

    public MMFlipper$c() {
        this.mlv = 1.3f;
        this.mlv = 0.0f;
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (f2 * f2)) + 1.0f;
    }
}
