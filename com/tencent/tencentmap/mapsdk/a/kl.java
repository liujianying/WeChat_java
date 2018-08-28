package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public class kl extends kk {
    private ox e;

    protected void a(float f, Interpolator interpolator) {
        float interpolation = interpolator.getInterpolation(f);
        if (this.d != null) {
            this.d.b(interpolation);
        }
    }

    public ox f() {
        return this.e;
    }
}
