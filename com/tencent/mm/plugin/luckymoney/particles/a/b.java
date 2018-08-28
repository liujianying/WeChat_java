package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b {
    private final Matrix aaw = new Matrix();
    public int alpha;
    private final Paint kSN = new Paint(1);
    public long kSO;
    public float kSP;
    public float kSQ;
    public float kSR;
    public float kSS;
    public Long kST;
    public Long kSU;
    public float kSV;
    public float kSW;
    public Long kSX;
    public float kSY;
    public float kSZ;
    public Interpolator kSd;
    public Rect kSe;
    public float kSj;
    public float kSl;
    public Float kSn;
    public Float kSp;
    public float kSv;
    public Float kSx;
    public long kSz;
    public float kTa;
    public float kTb;
    public float kTc;
    public boolean kTd;
    public boolean kTe;
    public VelocityTracker kTf;
    public float kTg;
    public float kTh;
    public float kTi;
    public float kTj;
    public boolean terminated;

    protected abstract void a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3);

    public abstract int getHeight();

    public abstract int getWidth();

    public final void i(Rect rect) {
        this.kSe = rect;
        this.kST = a(this.kSn, this.kSR, this.kSj);
        this.kSU = a(this.kSp, this.kSS, this.kSl);
        this.kSX = a(this.kSx, this.kSW, this.kSv);
        if (this.kSY == 0.0f) {
            this.kSY = this.kSz >= 0 ? (float) this.kSz : 9.223372E18f;
            this.kSY = Math.min((float) a(this.kSP, this.kSR, this.kSj, this.kST, this.kSn, rect.left - getWidth(), rect.right), this.kSY);
            this.kSY = Math.min((float) a(this.kSQ, this.kSS, this.kSl, this.kSU, this.kSp, rect.top - getHeight(), rect.bottom), this.kSY);
        }
        this.kSN.setAlpha(this.alpha);
    }

    private static Long a(Float f, float f2, float f3) {
        if (f == null) {
            return null;
        }
        if (f3 != 0.0f) {
            long floatValue = (long) ((f.floatValue() - f2) / f3);
            if (floatValue <= 0) {
                floatValue = 0;
            }
            return Long.valueOf(floatValue);
        } else if (f.floatValue() < f2) {
            return Long.valueOf(0);
        } else {
            return null;
        }
    }

    private static long a(float f, float f2, float f3, Long l, Float f4, int i, int i2) {
        double sqrt;
        if (f3 != 0.0f) {
            if (f3 <= 0.0f) {
                i2 = i;
            }
            if (l == null || l.longValue() < 0) {
                sqrt = Math.sqrt((double) ((((2.0f * f3) * ((float) i2)) - ((2.0f * f3) * f)) + (f2 * f2)));
                double d = ((-sqrt) - ((double) f2)) / ((double) f3);
                if (d > 0.0d) {
                    return (long) d;
                }
                sqrt = (sqrt - ((double) f2)) / ((double) f3);
                if (sqrt > 0.0d) {
                    return (long) sqrt;
                }
                return Long.MAX_VALUE;
            }
            sqrt = ((((double) ((((float) i2) - f) - (((float) l.longValue()) * f2))) - (((0.5d * ((double) f3)) * ((double) l.longValue())) * ((double) l.longValue()))) + ((double) (f4.floatValue() * ((float) l.longValue())))) / ((double) f4.floatValue());
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        } else {
            if (l != null) {
                f2 = f4.floatValue();
            }
            if (f2 <= 0.0f) {
                i2 = i;
            }
            if (f2 == 0.0f) {
                return Long.MAX_VALUE;
            }
            sqrt = (double) ((((float) i2) - f) / f2);
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        }
    }

    public static float a(long j, float f, float f2, float f3, Long l, Float f4) {
        if (l == null || j < l.longValue()) {
            return ((((float) j) * f2) + f) + (((0.5f * f3) * ((float) j)) * ((float) j));
        }
        return (((((float) l.longValue()) * f2) + f) + (((0.5f * f3) * ((float) l.longValue())) * ((float) l.longValue()))) + (((float) (j - l.longValue())) * f4.floatValue());
    }

    public final void a(Canvas canvas, float f, float f2, float f3) {
        canvas.save();
        canvas.clipRect(this.kSe);
        this.aaw.reset();
        this.kSN.setAlpha(this.alpha);
        a(canvas, this.aaw, this.kSN, f, f2, f3);
        canvas.restore();
    }
}
