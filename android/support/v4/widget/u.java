package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u {
    private static final Interpolator vY = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int[] CA;
    private int[] CB;
    private int CC;
    private float CD;
    float CE;
    int CF;
    int CG;
    private final a CH;
    View CI;
    private boolean CJ;
    private final ViewGroup CK;
    private final Runnable CL = new Runnable() {
        public final void run() {
            u.this.aB(0);
        }
    };
    int Cu;
    float[] Cv;
    float[] Cw;
    float[] Cx;
    float[] Cy;
    private int[] Cz;
    private VelocityTracker cE;
    private int cF = -1;
    private q fT;
    public int fW;

    public static abstract class a {
        public abstract boolean b(View view, int i);

        public void t(int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void f(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void cH() {
        }

        public void t(int i, int i2) {
        }

        public int s(View view) {
            return 0;
        }

        public int V() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    public static u a(ViewGroup viewGroup, a aVar) {
        return new u(viewGroup.getContext(), viewGroup, aVar);
    }

    public static u a(ViewGroup viewGroup, float f, a aVar) {
        u a = a(viewGroup, aVar);
        a.fW = (int) (((float) a.fW) * (1.0f / f));
        return a;
    }

    private u(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.CK = viewGroup;
            this.CH = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.CF = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.fW = viewConfiguration.getScaledTouchSlop();
            this.CD = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.CE = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.fT = q.a(context, vY);
        }
    }

    public final void n(View view, int i) {
        if (view.getParent() != this.CK) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.CK + ")");
        }
        this.CI = view;
        this.cF = i;
        this.CH.f(view, i);
        aB(1);
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

    public final void abort() {
        cancel();
        if (this.Cu == 2) {
            this.fT.getCurrX();
            this.fT.getCurrY();
            this.fT.abortAnimation();
            this.CH.a(this.CI, this.fT.getCurrX(), this.fT.getCurrY());
        }
        aB(0);
    }

    public final boolean d(View view, int i, int i2) {
        this.CI = view;
        this.cF = -1;
        boolean g = g(i, i2, 0, 0);
        if (!(g || this.Cu != 0 || this.CI == null)) {
            this.CI = null;
        }
        return g;
    }

    public final boolean w(int i, int i2) {
        if (this.CJ) {
            return g(i, i2, (int) y.a(this.cE, this.cF), (int) y.b(this.cE, this.cF));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean g(int i, int i2, int i3, int i4) {
        int left = this.CI.getLeft();
        int top = this.CI.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.fT.abortAnimation();
            aB(0);
            return false;
        }
        View view = this.CI;
        int k = k(i3, (int) this.CE, (int) this.CD);
        int k2 = k(i4, (int) this.CE, (int) this.CD);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(k);
        int abs4 = Math.abs(k2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.fT.startScroll(left, top, i5, i6, (int) (((k2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) j(i6, k2, this.CH.V()))) + ((k != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) j(i5, k, this.CH.s(view))))));
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

    public final boolean cX() {
        if (this.Cu == 2) {
            boolean computeScrollOffset = this.fT.computeScrollOffset();
            int currX = this.fT.getCurrX();
            int currY = this.fT.getCurrY();
            int left = currX - this.CI.getLeft();
            int top = currY - this.CI.getTop();
            if (left != 0) {
                z.k(this.CI, left);
            }
            if (top != 0) {
                z.j(this.CI, top);
            }
            if (!(left == 0 && top == 0)) {
                this.CH.a(this.CI, currX, currY);
            }
            if (computeScrollOffset && currX == this.fT.getFinalX() && currY == this.fT.getFinalY()) {
                this.fT.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.CK.post(this.CL);
            }
        }
        if (this.Cu == 2) {
            return true;
        }
        return false;
    }

    private void t(float f, float f2) {
        this.CJ = true;
        this.CH.a(this.CI, f, f2);
        this.CJ = false;
        if (this.Cu == 1) {
            aB(0);
        }
    }

    private void az(int i) {
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

    private void a(float f, float f2, int i) {
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

    private void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.Cx[c] = d;
            this.Cy[c] = e;
        }
    }

    public final boolean aA(int i) {
        return (this.CC & (1 << i)) != 0;
    }

    final void aB(int i) {
        this.CK.removeCallbacks(this.CL);
        if (this.Cu != i) {
            this.Cu = i;
            this.CH.t(i);
            if (this.Cu == 0) {
                this.CI = null;
            }
        }
    }

    private boolean o(View view, int i) {
        if (view == this.CI && this.cF == i) {
            return true;
        }
        if (view == null || !this.CH.b(view, i)) {
            return false;
        }
        this.cF = i;
        n(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.o.d(r14);
        r1 = android.support.v4.view.o.e(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.cE;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.cE = r2;
    L_0x0017:
        r2 = r13.cE;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x011f;
            case 2: goto L_0x008c;
            case 3: goto L_0x011f;
            case 4: goto L_0x001f;
            case 5: goto L_0x0057;
            case 6: goto L_0x0116;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.Cu;
        r1 = 1;
        if (r0 != r1) goto L_0x0124;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.o.c(r14, r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.x(r0, r1);
        r1 = r13.CI;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.Cu;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.o(r0, r2);
    L_0x0048:
        r0 = r13.Cz;
        r0 = r0[r2];
        r1 = r13.CG;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0051:
        r0 = r13.CH;
        r0.cH();
        goto L_0x001f;
    L_0x0057:
        r0 = android.support.v4.view.o.c(r14, r1);
        r2 = android.support.v4.view.o.d(r14, r1);
        r1 = android.support.v4.view.o.e(r14, r1);
        r13.a(r2, r1, r0);
        r3 = r13.Cu;
        if (r3 != 0) goto L_0x0079;
    L_0x006a:
        r1 = r13.Cz;
        r0 = r1[r0];
        r1 = r13.CG;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0073:
        r0 = r13.CH;
        r0.cH();
        goto L_0x001f;
    L_0x0079:
        r3 = r13.Cu;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x007e:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.x(r2, r1);
        r2 = r13.CI;
        if (r1 != r2) goto L_0x001f;
    L_0x0088:
        r13.o(r1, r0);
        goto L_0x001f;
    L_0x008c:
        r0 = r13.Cv;
        if (r0 == 0) goto L_0x001f;
    L_0x0090:
        r0 = r13.Cw;
        if (r0 == 0) goto L_0x001f;
    L_0x0094:
        r2 = android.support.v4.view.o.f(r14);
        r0 = 0;
        r1 = r0;
    L_0x009a:
        if (r1 >= r2) goto L_0x0111;
    L_0x009c:
        r3 = android.support.v4.view.o.c(r14, r1);
        r0 = r13.aC(r3);
        if (r0 == 0) goto L_0x010b;
    L_0x00a6:
        r0 = android.support.v4.view.o.d(r14, r1);
        r4 = android.support.v4.view.o.e(r14, r1);
        r5 = r13.Cv;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.Cw;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.x(r0, r4);
        if (r4 == 0) goto L_0x010f;
    L_0x00c2:
        r0 = r13.b(r4, r5, r6);
        if (r0 == 0) goto L_0x010f;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x00fb;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.CH;
        r8 = r9.d(r4, r8);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.CH;
        r10 = r11.c(r4, r10);
        r11 = r13.CH;
        r11 = r11.s(r4);
        r12 = r13.CH;
        r12 = r12.V();
        if (r11 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r11 <= 0) goto L_0x00fb;
    L_0x00f3:
        if (r8 != r7) goto L_0x00fb;
    L_0x00f5:
        if (r12 == 0) goto L_0x0111;
    L_0x00f7:
        if (r12 <= 0) goto L_0x00fb;
    L_0x00f9:
        if (r10 == r9) goto L_0x0111;
    L_0x00fb:
        r13.b(r5, r6, r3);
        r5 = r13.Cu;
        r6 = 1;
        if (r5 == r6) goto L_0x0111;
    L_0x0103:
        if (r0 == 0) goto L_0x010b;
    L_0x0105:
        r0 = r13.o(r4, r3);
        if (r0 != 0) goto L_0x0111;
    L_0x010b:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x009a;
    L_0x010f:
        r0 = 0;
        goto L_0x00c9;
    L_0x0111:
        r13.i(r14);
        goto L_0x001f;
    L_0x0116:
        r0 = android.support.v4.view.o.c(r14, r1);
        r13.az(r0);
        goto L_0x001f;
    L_0x011f:
        r13.cancel();
        goto L_0x001f;
    L_0x0124:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.u.j(android.view.MotionEvent):boolean");
    }

    public final void k(MotionEvent motionEvent) {
        int i = 0;
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        float x;
        float y;
        View x2;
        int left;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = o.c(motionEvent, 0);
                x2 = x((int) x, (int) y);
                a(x, y, i);
                o(x2, i);
                if ((this.Cz[i] & this.CG) != 0) {
                    this.CH.cH();
                    return;
                }
                return;
            case 1:
                if (this.Cu == 1) {
                    cY();
                }
                cancel();
                return;
            case 2:
                int f;
                if (this.Cu != 1) {
                    f = o.f(motionEvent);
                    while (i < f) {
                        d = o.c(motionEvent, i);
                        if (aC(d)) {
                            float d2 = o.d(motionEvent, i);
                            float e2 = o.e(motionEvent, i);
                            float f2 = d2 - this.Cv[d];
                            float f3 = e2 - this.Cw[d];
                            b(f2, f3, d);
                            if (this.Cu != 1) {
                                x2 = x((int) d2, (int) e2);
                                if (b(x2, f2, f3) && o(x2, d)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i++;
                    }
                    i(motionEvent);
                    return;
                } else if (aC(this.cF)) {
                    i = o.b(motionEvent, this.cF);
                    x = o.d(motionEvent, i);
                    d = (int) (x - this.Cx[this.cF]);
                    e = (int) (o.e(motionEvent, i) - this.Cy[this.cF]);
                    f = this.CI.getLeft() + d;
                    i = this.CI.getTop() + e;
                    left = this.CI.getLeft();
                    int top = this.CI.getTop();
                    if (d != 0) {
                        f = this.CH.d(this.CI, f);
                        z.k(this.CI, f - left);
                    }
                    if (e != 0) {
                        i = this.CH.c(this.CI, i);
                        z.j(this.CI, i - top);
                    }
                    if (!(d == 0 && e == 0)) {
                        this.CH.a(this.CI, f, i);
                    }
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.Cu == 1) {
                    t(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = o.c(motionEvent, e);
                x = o.d(motionEvent, e);
                y = o.e(motionEvent, e);
                a(x, y, i);
                if (this.Cu == 0) {
                    o(x((int) x, (int) y), i);
                    if ((this.Cz[i] & this.CG) != 0) {
                        this.CH.cH();
                        return;
                    }
                    return;
                }
                if (e(this.CI, (int) x, (int) y)) {
                    o(this.CI, i);
                    return;
                }
                return;
            case 6:
                d = o.c(motionEvent, e);
                if (this.Cu == 1 && d == this.cF) {
                    e = o.f(motionEvent);
                    while (i < e) {
                        left = o.c(motionEvent, i);
                        if (left != this.cF) {
                            if (x((int) o.d(motionEvent, i), (int) o.e(motionEvent, i)) == this.CI && o(this.CI, left)) {
                                i = this.cF;
                                if (i == -1) {
                                    cY();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        cY();
                    }
                }
                az(d);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
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
            iArr[i] = iArr[i] | i2;
            this.CH.t(i2, i);
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

    private boolean b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.CH.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.CH.V() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.fW * this.fW))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.fW)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.fW)) {
            return false;
        } else {
            return true;
        }
    }

    private void cY() {
        this.cE.computeCurrentVelocity(1000, this.CD);
        t(e(y.a(this.cE, this.cF), this.CE, this.CD), e(y.b(this.cE, this.cF), this.CE, this.CD));
    }

    public static boolean e(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
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

    private boolean aC(int i) {
        if (aA(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
