package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public class kj extends kk {
    private float e;
    private float f;

    protected void a(float f, Interpolator interpolator) {
        float interpolation = ((this.f - this.e) * interpolator.getInterpolation(f)) + this.e;
        if (this.d != null) {
            this.d.a(interpolation);
        }
    }
}
