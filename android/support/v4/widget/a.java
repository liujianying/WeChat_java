package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int yt = ViewConfiguration.getTapTimeout();
    private Runnable mRunnable;
    private final View me;
    private final a ye = new a();
    private final Interpolator yf = new AccelerateInterpolator();
    private float[] yg = new float[]{0.0f, 0.0f};
    private float[] yh = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int yi;
    private int yj;
    private float[] yk = new float[]{0.0f, 0.0f};
    private float[] yl = new float[]{0.0f, 0.0f};
    private float[] ym = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean yn;
    private boolean yo;
    private boolean yp;
    private boolean yq;
    private boolean yr;
    private boolean ys;

    private static class a {
        long mStartTime = Long.MIN_VALUE;
        int yA = 0;
        long yB = -1;
        float yC;
        int yD;
        int yu;
        int yv;
        float yw;
        float yx;
        long yy = 0;
        int yz = 0;

        final float j(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.yB < 0 || j < this.yB) {
                return a.d(((float) (j - this.mStartTime)) / ((float) this.yu), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.yB;
            return (a.d(((float) j2) / ((float) this.yD), 0.0f, 1.0f) * this.yC) + (1.0f - this.yC);
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final void run() {
            int i = 0;
            if (a.this.yq) {
                a d;
                if (a.this.yo) {
                    a.this.yo = false;
                    d = a.this.ye;
                    d.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    d.yB = -1;
                    d.yy = d.mStartTime;
                    d.yC = 0.5f;
                    d.yz = 0;
                    d.yA = 0;
                }
                d = a.this.ye;
                if (d.yB > 0 && AnimationUtils.currentAnimationTimeMillis() > d.yB + ((long) d.yD)) {
                    i = 1;
                }
                if (i == 0 && a.this.aA()) {
                    if (a.this.yp) {
                        a.this.yp = false;
                        a.i(a.this);
                    }
                    if (d.yy == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float j = d.j(currentAnimationTimeMillis);
                    j = (j * 4.0f) + ((-4.0f * j) * j);
                    long j2 = currentAnimationTimeMillis - d.yy;
                    d.yy = currentAnimationTimeMillis;
                    d.yz = (int) ((((float) j2) * j) * d.yw);
                    d.yA = (int) ((j * ((float) j2)) * d.yx);
                    a.this.aq(d.yA);
                    z.a(a.this.me, (Runnable) this);
                    return;
                }
                a.this.yq = false;
            }
        }
    }

    public abstract void aq(int i);

    public abstract boolean ar(int i);

    static /* synthetic */ void i(a aVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        aVar.me.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a(View view) {
        this.me = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.ym[0] = f / 1000.0f;
        this.ym[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.yl[0] = f2 / 1000.0f;
        this.yl[1] = f2 / 1000.0f;
        this.yi = 1;
        this.yh[0] = Float.MAX_VALUE;
        this.yh[1] = Float.MAX_VALUE;
        this.yg[0] = 0.2f;
        this.yg[1] = 0.2f;
        this.yk[0] = 0.001f;
        this.yk[1] = 0.001f;
        this.yj = yt;
        this.ye.yu = 500;
        this.ye.yv = 500;
    }

    public final a y(boolean z) {
        if (this.yr && !z) {
            cy();
        }
        this.yr = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.yr) {
            return false;
        }
        switch (o.d(motionEvent)) {
            case 0:
                this.yp = true;
                this.yn = false;
                break;
            case 1:
            case 3:
                cy();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.me.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.me.getHeight());
        a aVar = this.ye;
        aVar.yw = a;
        aVar.yx = a2;
        if (!this.yq && aA()) {
            if (this.mRunnable == null) {
                this.mRunnable = new b(this, (byte) 0);
            }
            this.yq = true;
            this.yo = true;
            if (this.yn || this.yj <= 0) {
                this.mRunnable.run();
            } else {
                z.a(this.me, this.mRunnable, (long) this.yj);
            }
            this.yn = true;
        }
        if (this.ys && this.yq) {
            return true;
        }
        return false;
    }

    private boolean aA() {
        a aVar = this.ye;
        int abs = (int) (aVar.yx / Math.abs(aVar.yx));
        int abs2 = (int) (aVar.yw / Math.abs(aVar.yw));
        if (abs != 0 && ar(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private void cy() {
        if (this.yo) {
            this.yq = false;
            return;
        }
        a aVar = this.ye;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - aVar.mStartTime);
        int i2 = aVar.yv;
        if (i <= i2) {
            i2 = i < 0 ? 0 : i;
        }
        aVar.yD = i2;
        aVar.yC = aVar.j(currentAnimationTimeMillis);
        aVar.yB = currentAnimationTimeMillis;
    }

    private float a(int i, float f, float f2, float f3) {
        float d = d(this.yg[i] * f2, 0.0f, this.yh[i]);
        d = r(f2 - f, d) - r(f, d);
        if (d < 0.0f) {
            d = -this.yf.getInterpolation(-d);
        } else if (d > 0.0f) {
            d = this.yf.getInterpolation(d);
        } else {
            d = 0.0f;
            if (d == 0.0f) {
                return 0.0f;
            }
            float f4 = this.yk[i];
            float f5 = this.yl[i];
            float f6 = this.ym[i];
            f4 *= f3;
            if (d > 0.0f) {
                return d(d * f4, f5, f6);
            }
            return -d((-d) * f4, f5, f6);
        }
        d = d(d, -1.0f, 1.0f);
        if (d == 0.0f) {
            return 0.0f;
        }
        float f42 = this.yk[i];
        float f52 = this.yl[i];
        float f62 = this.ym[i];
        f42 *= f3;
        if (d > 0.0f) {
            return d(d * f42, f52, f62);
        }
        return -d((-d) * f42, f52, f62);
    }

    private float r(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.yi) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.yq && this.yi == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static float d(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
