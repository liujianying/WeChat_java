package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.e;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.List;

public final class a extends g implements i {
    private d RJ = null;
    RecyclerView Sa;
    final List<View> XE = new ArrayList();
    private final float[] XF = new float[2];
    t XG = null;
    float XH;
    float XI;
    float XJ;
    float XK;
    float XL;
    float XM;
    float XN;
    float XO;
    a XP;
    int XQ = 0;
    int XR;
    List<c> XS = new ArrayList();
    private int XT;
    final Runnable XU = new 1(this);
    private List<t> XV;
    private List<Integer> XW;
    View XX = null;
    int XY = -1;
    e XZ;
    private final j Ya = new 2(this);
    long Yb;
    VelocityTracker cE;
    int cF = -1;
    Rect ea;

    /* renamed from: android.support.v7.widget.a.a$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int Yd;
        final /* synthetic */ c Yf;

        AnonymousClass4(c cVar, int i) {
            this.Yf = cVar;
            this.Yd = i;
        }

        public final void run() {
            if (a.this.Sa != null && a.this.Sa.isAttachedToWindow() && !this.Yf.Yt && this.Yf.Sh.gm() != -1) {
                RecyclerView.e itemAnimator = a.this.Sa.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.a(null)) {
                    Object obj;
                    a aVar = a.this;
                    int size = aVar.XS.size();
                    for (int i = 0; i < size; i++) {
                        if (!((c) aVar.XS.get(i)).mh) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        a.this.XP.ht();
                        return;
                    }
                }
                a.this.Sa.post(this);
            }
        }
    }

    public a(a aVar) {
        this.XP = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void A(RecyclerView recyclerView) {
        if (this.Sa != recyclerView) {
            RecyclerView recyclerView2;
            if (this.Sa != null) {
                RecyclerView recyclerView3 = this.Sa;
                if (recyclerView3.QV != null) {
                    recyclerView3.QV.O("Cannot remove item decoration during a scroll  or layout");
                }
                recyclerView3.QX.remove(this);
                if (recyclerView3.QX.isEmpty()) {
                    recyclerView3.setWillNotDraw(z.B(recyclerView3) == 2);
                }
                recyclerView3.fR();
                recyclerView3.requestLayout();
                recyclerView2 = this.Sa;
                j jVar = this.Ya;
                recyclerView2.QY.remove(jVar);
                if (recyclerView2.QZ == jVar) {
                    recyclerView2.QZ = null;
                }
                recyclerView2 = this.Sa;
                if (recyclerView2.Rk != null) {
                    recyclerView2.Rk.remove(this);
                }
                for (int size = this.XS.size() - 1; size >= 0; size--) {
                    this.XP.c(this.Sa, ((c) this.XS.get(0)).Sh);
                }
                this.XS.clear();
                this.XX = null;
                this.XY = -1;
                hl();
            }
            this.Sa = recyclerView;
            if (this.Sa != null) {
                Resources resources = recyclerView.getResources();
                this.XJ = resources.getDimension(android.support.v7.d.a.a.item_touch_helper_swipe_escape_velocity);
                this.XK = resources.getDimension(android.support.v7.d.a.a.item_touch_helper_swipe_escape_max_velocity);
                this.XT = ViewConfiguration.get(this.Sa.getContext()).getScaledTouchSlop();
                this.Sa.a(this);
                this.Sa.QY.add(this.Ya);
                recyclerView2 = this.Sa;
                if (recyclerView2.Rk == null) {
                    recyclerView2.Rk = new ArrayList();
                }
                recyclerView2.Rk.add(this);
                if (this.XZ == null) {
                    this.XZ = new e(this.Sa.getContext(), new b(this, (byte) 0));
                }
            }
        }
    }

    private void c(float[] fArr) {
        if ((this.XR & 12) != 0) {
            fArr[0] = (this.XN + this.XL) - ((float) this.XG.SU.getLeft());
        } else {
            fArr[0] = z.Q(this.XG.SU);
        }
        if ((this.XR & 3) != 0) {
            fArr[1] = (this.XO + this.XM) - ((float) this.XG.SU.getTop());
        } else {
            fArr[1] = z.R(this.XG.SU);
        }
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.XG != null) {
            c(this.XF);
            f = this.XF[0];
            f2 = this.XF[1];
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        a.a(canvas, recyclerView, this.XG, this.XS, this.XQ, f, f2);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        float f;
        float f2;
        this.XY = -1;
        if (this.XG != null) {
            c(this.XF);
            f = this.XF[0];
            f2 = this.XF[1];
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        a.a(this.XP, canvas, recyclerView, this.XG, this.XS, this.XQ, f, f2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void d(android.support.v7.widget.RecyclerView.t r13, int r14) {
        /*
        r12 = this;
        r0 = r12.XG;
        if (r13 != r0) goto L_0x0009;
    L_0x0004:
        r0 = r12.XQ;
        if (r14 != r0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = -9223372036854775808;
        r12.Yb = r0;
        r4 = r12.XQ;
        r0 = 1;
        r12.a(r13, r0);
        r12.XQ = r14;
        r0 = 2;
        if (r14 != r0) goto L_0x0034;
    L_0x0018:
        r0 = r13.SU;
        r12.XX = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0034;
    L_0x0022:
        r0 = r12.RJ;
        if (r0 != 0) goto L_0x002d;
    L_0x0026:
        r0 = new android.support.v7.widget.a.a$5;
        r0.<init>(r12);
        r12.RJ = r0;
    L_0x002d:
        r0 = r12.Sa;
        r1 = r12.RJ;
        r0.setChildDrawingOrderCallback(r1);
    L_0x0034:
        r0 = 1;
        r1 = r14 * 8;
        r1 = r1 + 8;
        r0 = r0 << r1;
        r11 = r0 + -1;
        r0 = 0;
        r1 = r12.XG;
        if (r1 == 0) goto L_0x00d1;
    L_0x0041:
        r2 = r12.XG;
        r1 = r2.SU;
        r1 = r1.getParent();
        if (r1 == 0) goto L_0x017d;
    L_0x004b:
        r0 = 2;
        if (r4 == r0) goto L_0x0132;
    L_0x004e:
        r0 = r12.XQ;
        r1 = 2;
        if (r0 == r1) goto L_0x0132;
    L_0x0053:
        r0 = r12.XP;
        r0 = r0.hm();
        r1 = r12.Sa;
        r1 = android.support.v4.view.z.I(r1);
        r0 = android.support.v7.widget.a.a.a.ap(r0, r1);
        r1 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r0 = r0 & r1;
        r0 = r0 >> 8;
        if (r0 == 0) goto L_0x0132;
    L_0x006b:
        r1 = r12.XL;
        r1 = java.lang.Math.abs(r1);
        r3 = r12.XM;
        r3 = java.lang.Math.abs(r3);
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0135;
    L_0x007b:
        r9 = r12.bS(r0);
        if (r9 <= 0) goto L_0x012c;
    L_0x0081:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0085:
        r0 = r12.Sa;
        r0 = android.support.v4.view.z.I(r0);
        r9 = android.support.v7.widget.a.a.a.ao(r9, r0);
    L_0x008f:
        r12.hl();
        switch(r9) {
            case 1: goto L_0x0163;
            case 2: goto L_0x0163;
            case 4: goto L_0x0151;
            case 8: goto L_0x0151;
            case 16: goto L_0x0151;
            case 32: goto L_0x0151;
            default: goto L_0x0095;
        };
    L_0x0095:
        r7 = 0;
        r8 = 0;
    L_0x0097:
        r0 = 2;
        if (r4 != r0) goto L_0x0175;
    L_0x009a:
        r3 = 8;
    L_0x009c:
        r0 = r12.XF;
        r12.c(r0);
        r0 = r12.XF;
        r1 = 0;
        r5 = r0[r1];
        r0 = r12.XF;
        r1 = 1;
        r6 = r0[r1];
        r0 = new android.support.v7.widget.a.a$3;
        r1 = r12;
        r10 = r2;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r1 = r12.Sa;
        r2 = android.support.v7.widget.a.a.a.f(r1, r3);
        r1 = r0.Yo;
        r1.setDuration(r2);
        r1 = r12.XS;
        r1.add(r0);
        r1 = r0.Sh;
        r2 = 0;
        r1.T(r2);
        r0 = r0.Yo;
        r0.start();
        r0 = 1;
    L_0x00ce:
        r1 = 0;
        r12.XG = r1;
    L_0x00d1:
        r1 = r0;
        if (r13 == 0) goto L_0x0101;
    L_0x00d4:
        r0 = r12.Sa;
        r0 = android.support.v7.widget.a.a.a.B(r0);
        r0 = r0 & r11;
        r2 = r12.XQ;
        r2 = r2 * 8;
        r0 = r0 >> r2;
        r12.XR = r0;
        r0 = r13.SU;
        r0 = r0.getLeft();
        r0 = (float) r0;
        r12.XN = r0;
        r0 = r13.SU;
        r0 = r0.getTop();
        r0 = (float) r0;
        r12.XO = r0;
        r12.XG = r13;
        r0 = 2;
        if (r14 != r0) goto L_0x0101;
    L_0x00f9:
        r0 = r12.XG;
        r0 = r0.SU;
        r2 = 0;
        r0.performHapticFeedback(r2);
    L_0x0101:
        r0 = r12.Sa;
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0111;
    L_0x0109:
        r0 = r12.XG;
        if (r0 == 0) goto L_0x018b;
    L_0x010d:
        r0 = 1;
    L_0x010e:
        r2.requestDisallowInterceptTouchEvent(r0);
    L_0x0111:
        if (r1 != 0) goto L_0x011c;
    L_0x0113:
        r0 = r12.Sa;
        r0 = r0.getLayoutManager();
        r1 = 1;
        r0.Sc = r1;
    L_0x011c:
        r0 = r12.XP;
        r1 = r12.XG;
        r2 = r12.XQ;
        r0.e(r1, r2);
        r0 = r12.Sa;
        r0.invalidate();
        goto L_0x0008;
    L_0x012c:
        r9 = r12.bT(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x0132:
        r9 = 0;
        goto L_0x008f;
    L_0x0135:
        r9 = r12.bT(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x013b:
        r9 = r12.bS(r0);
        if (r9 <= 0) goto L_0x0132;
    L_0x0141:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0145:
        r0 = r12.Sa;
        r0 = android.support.v4.view.z.I(r0);
        r9 = android.support.v7.widget.a.a.a.ao(r9, r0);
        goto L_0x008f;
    L_0x0151:
        r8 = 0;
        r0 = r12.XL;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.Sa;
        r1 = r1.getWidth();
        r1 = (float) r1;
        r7 = r0 * r1;
        goto L_0x0097;
    L_0x0163:
        r7 = 0;
        r0 = r12.XM;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.Sa;
        r1 = r1.getHeight();
        r1 = (float) r1;
        r8 = r0 * r1;
        goto L_0x0097;
    L_0x0175:
        if (r9 <= 0) goto L_0x017a;
    L_0x0177:
        r3 = 2;
        goto L_0x009c;
    L_0x017a:
        r3 = 4;
        goto L_0x009c;
    L_0x017d:
        r1 = r2.SU;
        r12.bx(r1);
        r1 = r12.XP;
        r3 = r12.Sa;
        r1.c(r3, r2);
        goto L_0x00ce;
    L_0x018b:
        r0 = 0;
        goto L_0x010e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.d(android.support.v7.widget.RecyclerView$t, int):void");
    }

    public final void bl(View view) {
        bx(view);
        t aP = this.Sa.aP(view);
        if (aP != null) {
            if (this.XG == null || aP != this.XG) {
                a(aP, false);
                if (this.XE.remove(aP.SU)) {
                    this.XP.c(this.Sa, aP);
                    return;
                }
                return;
            }
            d(null, 0);
        }
    }

    final int a(t tVar, boolean z) {
        for (int size = this.XS.size() - 1; size >= 0; size--) {
            c cVar = (c) this.XS.get(size);
            if (cVar.Sh == tVar) {
                cVar.Yt |= z;
                if (!cVar.mh) {
                    cVar.Yo.cancel();
                }
                this.XS.remove(size);
                return cVar.Yp;
            }
        }
        return 0;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.setEmpty();
    }

    private void hl() {
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
    }

    final View p(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.XG != null) {
            View view = this.XG.SU;
            if (a(view, x, y, this.XN + this.XL, this.XO + this.XM)) {
                return view;
            }
        }
        for (int size = this.XS.size() - 1; size >= 0; size--) {
            c cVar = (c) this.XS.get(size);
            View view2 = cVar.Sh.SU;
            if (a(view2, x, y, cVar.Yr, cVar.Ys)) {
                return view2;
            }
        }
        return this.Sa.u(x, y);
    }

    private int bS(int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.XL > 0.0f ? 8 : 4;
            if (this.cE != null && this.cF >= 0) {
                this.cE.computeCurrentVelocity(1000, a.K(this.XK));
                float a = y.a(this.cE, this.cF);
                float b = y.b(this.cE, this.cF);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= a.J(this.XJ) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.Sa.getWidth()) * a.hr();
            if ((i & i3) != 0 && Math.abs(this.XL) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int bT(int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.XM > 0.0f ? 2 : 1;
            if (this.cE != null && this.cF >= 0) {
                this.cE.computeCurrentVelocity(1000, a.K(this.XK));
                float a = y.a(this.cE, this.cF);
                float b = y.b(this.cE, this.cF);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= a.J(this.XJ) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.Sa.getHeight()) * a.hr();
            if ((i & i3) != 0 && Math.abs(this.XM) > height) {
                return i3;
            }
        }
        return 0;
    }

    final void bx(View view) {
        if (view == this.XX) {
            this.XX = null;
            if (this.RJ != null) {
                this.Sa.setChildDrawingOrderCallback(null);
            }
        }
    }
}
