package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.u.e;
import android.view.animation.Interpolator;

final class w extends e {
    final ValueAnimator iY = new ValueAnimator();

    w() {
    }

    public final void start() {
        this.iY.start();
    }

    public final boolean isRunning() {
        return this.iY.isRunning();
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.iY.setInterpolator(interpolator);
    }

    public final void a(u$e$b u_e_b) {
        this.iY.addUpdateListener(new 1(this, u_e_b));
    }

    public final void a(u$e$a u_e_a) {
        this.iY.addListener(new 2(this, u_e_a));
    }

    public final void i(int i, int i2) {
        this.iY.setIntValues(new int[]{i, i2});
    }

    public final int aQ() {
        return ((Integer) this.iY.getAnimatedValue()).intValue();
    }

    public final void p(float f, float f2) {
        this.iY.setFloatValues(new float[]{f, f2});
    }

    public final float aR() {
        return ((Float) this.iY.getAnimatedValue()).floatValue();
    }

    public final void setDuration(int i) {
        this.iY.setDuration((long) i);
    }

    public final void cancel() {
        this.iY.cancel();
    }

    public final float getAnimatedFraction() {
        return this.iY.getAnimatedFraction();
    }

    public final long getDuration() {
        return this.iY.getDuration();
    }
}
