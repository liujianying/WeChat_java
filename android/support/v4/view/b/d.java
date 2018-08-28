package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] ya;
    private final float yb = (1.0f / ((float) (this.ya.length - 1)));

    public d(float[] fArr) {
        this.ya = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.ya.length - 1)) * f), this.ya.length - 2);
        float f2 = (f - (((float) min) * this.yb)) / this.yb;
        return ((this.ya[min + 1] - this.ya[min]) * f2) + this.ya[min];
    }
}
