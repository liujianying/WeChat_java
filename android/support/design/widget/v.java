package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.u.e;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class v extends e {
    private static final Handler gA = new Handler(Looper.getMainLooper());
    private final int[] iS = new int[2];
    private final float[] iT = new float[2];
    private u$e$a iU;
    private u$e$b iV;
    private float iW;
    private int mDuration = 200;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private final Runnable mRunnable = new 1(this);
    private long mStartTime;

    v() {
    }

    public final void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.mIsRunning = true;
            gA.postDelayed(this.mRunnable, 10);
        }
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void a(u$e$a u_e_a) {
        this.iU = u_e_a;
    }

    public final void a(u$e$b u_e_b) {
        this.iV = u_e_b;
    }

    public final void i(int i, int i2) {
        this.iS[0] = i;
        this.iS[1] = i2;
    }

    public final int aQ() {
        return a.a(this.iS[0], this.iS[1], this.iW);
    }

    public final void p(float f, float f2) {
        this.iT[0] = f;
        this.iT[1] = f2;
    }

    public final float aR() {
        return a.b(this.iT[0], this.iT[1], this.iW);
    }

    public final void setDuration(int i) {
        this.mDuration = i;
    }

    public final void cancel() {
        this.mIsRunning = false;
        gA.removeCallbacks(this.mRunnable);
    }

    public final float getAnimatedFraction() {
        return this.iW;
    }

    public final long getDuration() {
        return (long) this.mDuration;
    }
}
