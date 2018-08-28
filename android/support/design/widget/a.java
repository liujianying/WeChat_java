package android.support.design.widget;

import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

final class a {
    static final Interpolator bL = new LinearInterpolator();
    static final Interpolator bM = new b();
    static final Interpolator bN = new android.support.v4.view.b.a();
    static final Interpolator bO = new c();
    static final Interpolator bP = new DecelerateInterpolator();

    static float b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
