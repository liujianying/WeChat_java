package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class a {
    private static final Interpolator vY = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int[] CA;
    private int[] CB;
    public int CC;
    public float CD;
    public float CE;
    private int CF;
    public int CG;
    public View CI;
    public boolean CJ;
    public final ViewGroup CK;
    public final Runnable CL = new Runnable() {
        public final void run() {
            a.this.aB(0);
        }
    };
    public int Cu;
    public float[] Cv;
    public float[] Cw;
    public float[] Cx;
    public float[] Cy;
    public int[] Cz;
    public VelocityTracker cE;
    public int cF = -1;
    public q fT;
    private int fW;
    public final a uuI;

    public static abstract class a {
        public abstract boolean Gc(int i);

        public void t(int i) {
        }

        public void fd(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public int czp() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }
    }

    public static a a(ViewGroup viewGroup, a aVar) {
        return new a(viewGroup.getContext(), viewGroup, aVar);
    }

    private a(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.CK = viewGroup;
            this.uuI = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.CF = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.fW = viewConfiguration.getScaledTouchSlop();
            this.CD = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.CE = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.fT = q.a(context, vY);
        }
    }

    public final void cancel() {
        this.cF = -1;
        if (this.Cv != null) {
            Arrays.fill(this.Cv, 0.0f);
            Arrays.fill(this.Cw, 0.0f);
            Arrays.fill(this.Cx, 0.0f);
            Arrays.fill(this.Cy, 0.0f);
            Arrays.fill(this.Cz, 0);
            Arrays.fill(this.CA, 0);
            Arrays.fill(this.CB, 0);
            this.CC = 0;
        }
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
    }

    public final boolean g(int i, int i2, int i3, int i4) {
        int left = this.CI.getLeft();
        int top = this.CI.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.fT.abortAnimation();
            aB(0);
            return false;
        }
        int k = k(i3, (int) this.CE, (int) this.CD);
        int k2 = k(i4, (int) this.CE, (int) this.CD);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(k);
        int abs4 = Math.abs(k2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        x.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) (((k2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) j(i6, k2, 0))) + ((k != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) j(i5, k, this.uuI.czp()))))));
        this.fT.startScroll(left, top, i5, i6, abs3);
        aB(2);
        return true;
    }

    private int j(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.CK.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int k(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float e(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final void t(float f, float f2) {
        this.CJ = true;
        this.uuI.a(this.CI, f, f2);
        this.CJ = false;
        if (this.Cu == 1) {
            aB(0);
        }
    }

    public final void az(int i) {
        if (this.Cv != null) {
            this.Cv[i] = 0.0f;
            this.Cw[i] = 0.0f;
            this.Cx[i] = 0.0f;
            this.Cy[i] = 0.0f;
            this.Cz[i] = 0;
            this.CA[i] = 0;
            this.CB[i] = 0;
            this.CC &= (1 << i) ^ -1;
        }
    }

    public final void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.Cv == null || this.Cv.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.Cv != null) {
                System.arraycopy(this.Cv, 0, obj, 0, this.Cv.length);
                System.arraycopy(this.Cw, 0, obj2, 0, this.Cw.length);
                System.arraycopy(this.Cx, 0, obj3, 0, this.Cx.length);
                System.arraycopy(this.Cy, 0, obj4, 0, this.Cy.length);
                System.arraycopy(this.Cz, 0, obj5, 0, this.Cz.length);
                System.arraycopy(this.CA, 0, obj6, 0, this.CA.length);
                System.arraycopy(this.CB, 0, obj7, 0, this.CB.length);
            }
            this.Cv = obj;
            this.Cw = obj2;
            this.Cx = obj3;
            this.Cy = obj4;
            this.Cz = obj5;
            this.CA = obj6;
            this.CB = obj7;
        }
        float[] fArr = this.Cv;
        this.Cx[i] = f;
        fArr[i] = f;
        fArr = this.Cw;
        this.Cy[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.Cz;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.CK.getLeft() + this.CF) {
            i2 = 1;
        }
        if (i4 < this.CK.getTop() + this.CF) {
            i2 |= 4;
        }
        if (i3 > this.CK.getRight() - this.CF) {
            i2 |= 2;
        }
        if (i4 > this.CK.getBottom() - this.CF) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.CC |= 1 << i;
    }

    public final void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.Cx[c] = d;
            this.Cy[c] = e;
        }
    }

    final void aB(int i) {
        if (this.Cu != i) {
            this.Cu = i;
            this.uuI.t(i);
            if (i == 0) {
                this.CI = null;
            }
        }
    }

    public final boolean o(View view, int i) {
        if (view == this.CI && this.cF == i) {
            return true;
        }
        if (view == null || !this.uuI.Gc(i)) {
            return false;
        }
        this.cF = i;
        if (view.getParent() != this.CK) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.CK + ")");
        }
        this.CI = view;
        this.cF = i;
        aB(1);
        return true;
    }

    public final void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.CA;
            iArr[i] = i2 | iArr[i];
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.Cz[i] & i2) != i2 || (this.CG & i2) == 0 || (this.CB[i] & i2) == i2 || (this.CA[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.fW) || abs2 > ((float) this.fW)) && (this.CA[i] & i2) == 0 && abs > ((float) this.fW)) {
            return true;
        }
        return false;
    }

    public final boolean l(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.uuI.czp() > 0) || Math.abs(f) <= ((float) this.fW)) {
            return false;
        }
        return true;
    }

    public final void cY() {
        this.cE.computeCurrentVelocity(1000, this.CD);
        t(e(y.a(this.cE, this.cF), this.CE, this.CD), e(y.b(this.cE, this.cF), this.CE, this.CD));
    }

    public final View x(int i, int i2) {
        for (int childCount = this.CK.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.CK.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
