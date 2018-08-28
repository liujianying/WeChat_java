package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.f;

public class SwipeBackLayout extends FrameLayout {
    public View FU;
    private Rect ea;
    private boolean mEnable;
    private boolean mInLayout;
    private float uHW;
    private int uHX;
    private int uHY;
    public com.tencent.mm.ui.mogic.a uHZ;
    private float uIa;
    public Drawable uIb;
    private boolean uIc;
    private boolean uId;
    public boolean uIe;
    public boolean uIf;
    public boolean uIg;
    private boolean uIh;
    private b uIi;
    private boolean uIj;
    public a uIk;
    private float zj;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    public interface b {
        void G(MotionEvent motionEvent);

        void aw(float f);

        boolean ke(boolean z);
    }

    private class c extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int uIl;
        int uIm;
        int uIn;

        private c() {
            this.uIl = 0;
            this.uIm = 0;
            this.uIn = 0;
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        public final boolean Gc(int i) {
            boolean z;
            com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.uHZ;
            if ((a.CC & (1 << i)) != 0) {
                z = true;
            } else {
                z = false;
            }
            return z && (a.Cz[i] & 1) != 0;
        }

        public final int czp() {
            return 1;
        }

        public final void fd(int i, int i2) {
            if (SwipeBackLayout.this.uIe) {
                SwipeBackLayout.this.uIa = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.FU.getWidth() + SwipeBackLayout.this.uIb.getIntrinsicWidth())));
                SwipeBackLayout.this.uHX = i;
                SwipeBackLayout.this.uHY = i2;
                SwipeBackLayout.this.invalidate();
                if (SwipeBackLayout.this.uIi != null) {
                    SwipeBackLayout.this.uIi.aw(SwipeBackLayout.this.uIa);
                }
                if (Float.compare(SwipeBackLayout.this.uIa, 1.0f) >= 0 && !SwipeBackLayout.this.uIf) {
                    SwipeBackLayout.this.uIf = true;
                    ah.A(new Runnable() {
                        public final void run() {
                            if (SwipeBackLayout.this.uIk != null) {
                                SwipeBackLayout.this.uIk.onSwipeBack();
                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            }
                            SwipeBackLayout.this.uIg = false;
                        }
                    });
                } else if (Float.compare(SwipeBackLayout.this.uIa, 0.01f) <= 0) {
                    SwipeBackLayout.this.uIg = false;
                }
                if (SwipeBackLayout.this.uHZ.Cu == 1) {
                    g.aD(SwipeBackLayout.this.uIa);
                }
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z = false;
            int width = view.getWidth();
            this.uIm = 0;
            this.uIn = 0;
            width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.uIa > SwipeBackLayout.this.uHW)) ? (width + SwipeBackLayout.this.uIb.getIntrinsicWidth()) + 10 : 0;
            this.uIm = width;
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.uIm), Integer.valueOf(this.uIn), Boolean.valueOf(SwipeBackLayout.this.uIe));
            SwipeBackLayout.this.uIg = true;
            if (SwipeBackLayout.this.uIi != null) {
                b e = SwipeBackLayout.this.uIi;
                if (this.uIm != 0) {
                    z = true;
                }
                if (e.ke(z)) {
                    x.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased");
                    return;
                }
            }
            if (SwipeBackLayout.this.uIe) {
                com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.uHZ;
                int i = this.uIm;
                int i2 = this.uIn;
                if (a.CJ) {
                    a.g(i, i2, (int) y.a(a.cE, a.cF), (int) y.b(a.cE, a.cF));
                    SwipeBackLayout.this.invalidate();
                    return;
                }
                throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            }
            SwipeBackLayout.this.uIh = true;
        }

        public final int d(View view, int i) {
            if (SwipeBackLayout.this.uIe) {
                int max = Math.max(this.uIl, i);
                this.uIl = 0;
                return Math.min(view.getWidth(), Math.max(max, 0));
            }
            this.uIl = Math.max(this.uIl, i);
            return 0;
        }

        public final void t(int i) {
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(SwipeBackLayout.this.uId), Boolean.valueOf(SwipeBackLayout.this.uIh));
            if (1 == i) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if (SwipeBackLayout.this.getContext() instanceof Activity) {
                    ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(d.transparent);
                }
                if (SwipeBackLayout.this.uIk != null) {
                    SwipeBackLayout.this.uIk.onDrag();
                }
                SwipeBackLayout.this.uIf = false;
                if (SwipeBackLayout.this.uIe) {
                    g.aD(0.0f);
                }
            }
            if (i == 0 && !SwipeBackLayout.this.uIh) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (SwipeBackLayout.this.uIk != null) {
                    SwipeBackLayout.this.uIk.onCancel();
                }
                g.aD(1.0f);
            }
            if (1 == i && SwipeBackLayout.this.uIc && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.uIe && !SwipeBackLayout.this.uId) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                SwipeBackLayout.this.uId = true;
                com.tencent.mm.ui.base.b.a((Activity) SwipeBackLayout.this.getContext(), this);
            }
            if (2 == i) {
                boolean z;
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.uIm));
                if (this.uIm > 0) {
                    z = true;
                } else {
                    z = false;
                }
                g.A(z, this.uIm);
            }
        }

        public final void kh(final boolean z) {
            ah.A(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(c.this.uIm));
                    SwipeBackLayout.this.uId = z;
                    if (!z) {
                        SwipeBackLayout.this.uIg = false;
                    } else if (c.this.uIm > 0) {
                        g.aD(0.0f);
                    } else {
                        g.aD(1.0f);
                    }
                    SwipeBackLayout.this.mC(z);
                    if (z && SwipeBackLayout.this.uIh) {
                        if (c.this.uIm == 0) {
                            i.a(SwipeBackLayout.this.FU, 200, 0.0f, new com.tencent.mm.ui.tools.i.a() {
                                public final void onAnimationEnd() {
                                    SwipeBackLayout.this.uIg = false;
                                }

                                public final void bWQ() {
                                    onAnimationEnd();
                                }
                            });
                        } else {
                            i.a(SwipeBackLayout.this.FU, 200, (float) c.this.uIm, new com.tencent.mm.ui.tools.i.a() {
                                public final void onAnimationEnd() {
                                    SwipeBackLayout.this.uIf = true;
                                    ah.A(new Runnable() {
                                        public final void run() {
                                            if (SwipeBackLayout.this.uIk != null) {
                                                SwipeBackLayout.this.uIk.onSwipeBack();
                                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            g.aD(1.0f);
                                            SwipeBackLayout.this.uIg = false;
                                        }
                                    });
                                }

                                public final void bWQ() {
                                    onAnimationEnd();
                                }
                            });
                            g.A(true, c.this.uIm);
                        }
                    }
                    SwipeBackLayout.this.uIh = false;
                }
            });
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.uHW = 0.3f;
        this.mEnable = true;
        this.ea = new Rect();
        this.uIc = true;
        this.uId = false;
        this.uIe = false;
        this.uIf = false;
        this.uIg = false;
        this.uIh = false;
        this.uIk = null;
        this.uIb = getResources().getDrawable(f.shadow_left);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
    }

    public final void init() {
        this.uHZ = com.tencent.mm.ui.mogic.a.a(this, new c(this, (byte) 0));
        this.uHZ.CG = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.uHZ.CE = f2;
        this.uHZ.CD = f;
        this.uHX = 0;
        this.uHY = 0;
    }

    public final void mC(boolean z) {
        x.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.uIe = z;
    }

    public void setNeedRequestActivityTranslucent(boolean z) {
        this.uIc = z;
        if (this.uIc) {
            this.uId = false;
        }
    }

    public void setSwipeBackListener(b bVar) {
        this.uIi = bVar;
    }

    public final boolean ceH() {
        cAF();
        return this.uIg;
    }

    public void setContentView(View view) {
        this.FU = view;
    }

    public View getTargetContentView() {
        return this.FU;
    }

    public void onFinishInflate() {
        this.FU = this;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setOnceDisEnableGesture(boolean z) {
        x.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", Boolean.valueOf(z));
        this.uIj = z;
    }

    public final boolean cAF() {
        if (!this.uIg) {
            return false;
        }
        if (Float.compare((float) this.FU.getLeft(), 0.01f) > 0) {
            return true;
        }
        this.uIg = false;
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r7 = 2;
        r3 = -1;
        r0 = 1;
        r1 = 0;
        r2 = r11.mEnable;
        if (r2 != 0) goto L_0x000d;
    L_0x0008:
        r0 = super.dispatchTouchEvent(r12);
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = r11.uIi;
        if (r2 == 0) goto L_0x0016;
    L_0x0011:
        r2 = r11.uIi;
        r2.G(r12);
    L_0x0016:
        r2 = r12.getAction();
        if (r2 != 0) goto L_0x001e;
    L_0x001c:
        r11.uIj = r1;
    L_0x001e:
        r2 = r11.uIj;
        if (r2 == 0) goto L_0x0027;
    L_0x0022:
        r0 = super.dispatchTouchEvent(r12);
        goto L_0x000c;
    L_0x0027:
        r2 = r11.cAF();
        if (r2 == 0) goto L_0x0032;
    L_0x002d:
        r0 = super.dispatchTouchEvent(r12);
        goto L_0x000c;
    L_0x0032:
        r2 = r11.uHZ;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x01f6;
    L_0x0038:
        r4 = r11.uHZ;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = android.support.v4.view.o.d(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = android.support.v4.view.o.e(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != 0) goto L_0x0047;
    L_0x0044:
        r4.cancel();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0047:
        r6 = r4.cE;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 != 0) goto L_0x0051;
    L_0x004b:
        r6 = android.view.VelocityTracker.obtain();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.cE = r6;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0051:
        r6 = r4.cE;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6.addMovement(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        switch(r2) {
            case 0: goto L_0x005a;
            case 1: goto L_0x01dc;
            case 2: goto L_0x00e3;
            case 3: goto L_0x01e8;
            case 4: goto L_0x0059;
            case 5: goto L_0x007d;
            case 6: goto L_0x0198;
            default: goto L_0x0059;
        };	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0059:
        goto L_0x000c;
    L_0x005a:
        r2 = r12.getX();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r12.getY();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = 0;
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = (int) r2;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = (int) r3;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r4.x(r6, r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.a(r2, r3, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.o(r6, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r4.Cz;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r1 = r4.CG;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r1 = r1 & r2;
        if (r1 == 0) goto L_0x000c;
    L_0x007c:
        goto L_0x000c;
    L_0x007d:
        r3 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = android.support.v4.view.o.d(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = android.support.v4.view.o.e(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.a(r2, r5, r3);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 != 0) goto L_0x00aa;
    L_0x0090:
        r2 = (int) r2;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = (int) r5;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r4.x(r2, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.o(r2, r3);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x009b:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an NullPointerException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x00aa:
        r2 = (int) r2;
        r5 = (int) r5;
        r6 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 == 0) goto L_0x00e1;
    L_0x00b0:
        r7 = r6.getLeft();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 < r7) goto L_0x00e1;
    L_0x00b6:
        r7 = r6.getRight();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 >= r7) goto L_0x00e1;
    L_0x00bc:
        r2 = r6.getTop();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 < r2) goto L_0x00e1;
    L_0x00c2:
        r2 = r6.getBottom();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 >= r2) goto L_0x00e1;
    L_0x00c8:
        r2 = r0;
    L_0x00c9:
        if (r2 == 0) goto L_0x000c;
    L_0x00cb:
        r2 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4.o(r2, r3);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x00d2:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an IllegalArgumentException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x00e1:
        r2 = r1;
        goto L_0x00c9;
    L_0x00e3:
        r2 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x0158;
    L_0x00e7:
        r2 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = android.support.v4.view.o.b(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = r4.Cx;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = r5[r6];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r3 - r5;
        r5 = (int) r3;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r4.Cy;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r3[r6];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2 - r3;
        r6 = (int) r2;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2.getLeft();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r2 + r5;
        r2 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2.getTop();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2 + r6;
        r7 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = r7.getLeft();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r8.getTop();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 == 0) goto L_0x0131;
    L_0x0122:
        r9 = r4.uuI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r10 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3 = r9.d(r10, r3);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = r3 - r7;
        r9.offsetLeftAndRight(r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0131:
        if (r6 == 0) goto L_0x013b;
    L_0x0133:
        r2 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = 0 - r8;
        r2.offsetTopAndBottom(r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r1;
    L_0x013b:
        if (r5 != 0) goto L_0x013f;
    L_0x013d:
        if (r6 == 0) goto L_0x0144;
    L_0x013f:
        r5 = r4.uuI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5.fd(r3, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0144:
        r4.i(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x0149:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an ArrayIndexOutOfBoundsException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x0158:
        r3 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r1;
    L_0x015d:
        if (r2 >= r3) goto L_0x0193;
    L_0x015f:
        r5 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r4.Cv;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r8[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r6 - r8;
        r9 = r4.Cw;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r9[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r7 - r9;
        r4.b(r8, r9, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r9 == r0) goto L_0x0193;
    L_0x017e:
        r6 = (int) r6;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = (int) r7;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r4.x(r6, r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = r4.l(r6, r8);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r7 == 0) goto L_0x0190;
    L_0x018a:
        r5 = r4.o(r6, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 != 0) goto L_0x0193;
    L_0x0190:
        r2 = r2 + 1;
        goto L_0x015d;
    L_0x0193:
        r4.i(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x0198:
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x01d4;
    L_0x01a0:
        r2 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 != r2) goto L_0x01d4;
    L_0x01a4:
        r6 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r1;
    L_0x01a9:
        if (r2 >= r6) goto L_0x02de;
    L_0x01ab:
        r7 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r7 == r8) goto L_0x01d9;
    L_0x01b3:
        r8 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = (int) r8;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = (int) r9;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r4.x(r8, r9);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r8 != r9) goto L_0x01d9;
    L_0x01c5:
        r8 = r4.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = r4.o(r8, r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r7 == 0) goto L_0x01d9;
    L_0x01cd:
        r2 = r4.cF;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x01cf:
        if (r2 != r3) goto L_0x01d4;
    L_0x01d1:
        r4.cY();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x01d4:
        r4.az(r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x01d9:
        r2 = r2 + 1;
        goto L_0x01a9;
    L_0x01dc:
        r2 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x01e3;
    L_0x01e0:
        r4.cY();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x01e3:
        r4.cancel();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x01e8:
        r2 = r4.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x01f1;
    L_0x01ec:
        r2 = 0;
        r3 = 0;
        r4.t(r2, r3);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x01f1:
        r4.cancel();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x01f6:
        r3 = r11.uHZ;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = android.support.v4.view.o.d(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = android.support.v4.view.o.e(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != 0) goto L_0x0205;
    L_0x0202:
        r3.cancel();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0205:
        r5 = r3.cE;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 != 0) goto L_0x020f;
    L_0x0209:
        r5 = android.view.VelocityTracker.obtain();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3.cE = r5;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x020f:
        r5 = r3.cE;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5.addMovement(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        switch(r2) {
            case 0: goto L_0x0236;
            case 1: goto L_0x02d1;
            case 2: goto L_0x0286;
            case 3: goto L_0x02d1;
            case 4: goto L_0x0217;
            case 5: goto L_0x0261;
            case 6: goto L_0x02c8;
            default: goto L_0x0217;
        };	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0217:
        r2 = r3.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r0) goto L_0x02d6;
    L_0x021b:
        r2 = r0;
    L_0x021c:
        if (r2 == 0) goto L_0x02d9;
    L_0x021e:
        r2 = "changelcai";
        r3 = "shouldInterceptTouchEvent %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = 3;
        r12.setAction(r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        super.dispatchTouchEvent(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x0236:
        r2 = r12.getX();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = r12.getY();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = 0;
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3.a(r2, r4, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = (int) r2;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = (int) r4;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r3.x(r2, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = r3.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r2 != r4) goto L_0x0257;
    L_0x0250:
        r4 = r3.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r4 != r7) goto L_0x0257;
    L_0x0254:
        r3.o(r2, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
    L_0x0257:
        r2 = r3.Cz;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = r3.CG;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r2 & r4;
        if (r2 == 0) goto L_0x0217;
    L_0x0260:
        goto L_0x0217;
    L_0x0261:
        r2 = android.support.v4.view.o.c(r12, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = android.support.v4.view.o.d(r12, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = android.support.v4.view.o.e(r12, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3.a(r5, r4, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r3.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 == 0) goto L_0x0217;
    L_0x0274:
        r6 = r3.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 != r7) goto L_0x0217;
    L_0x0278:
        r5 = (int) r5;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = (int) r4;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r4 = r3.x(r5, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r5 = r3.CI;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r4 != r5) goto L_0x0217;
    L_0x0282:
        r3.o(r4, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x0217;
    L_0x0286:
        r4 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r2 = r1;
    L_0x028b:
        if (r2 >= r4) goto L_0x02c3;
    L_0x028d:
        r5 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r3.Cv;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r8[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r8 = r6 - r8;
        r9 = r3.Cw;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r9[r5];	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r7 - r9;
        r3.b(r8, r9, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r9 = r3.Cu;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r9 == r0) goto L_0x02c3;
    L_0x02ac:
        r6 = (int) r6;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r7 = (int) r7;	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r6 = r3.x(r6, r7);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r6 == 0) goto L_0x02c0;
    L_0x02b4:
        r7 = r3.l(r6, r8);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r7 == 0) goto L_0x02c0;
    L_0x02ba:
        r5 = r3.o(r6, r5);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        if (r5 != 0) goto L_0x02c3;
    L_0x02c0:
        r2 = r2 + 1;
        goto L_0x028b;
    L_0x02c3:
        r3.i(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x0217;
    L_0x02c8:
        r2 = android.support.v4.view.o.c(r12, r4);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        r3.az(r2);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x0217;
    L_0x02d1:
        r3.cancel();	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x0217;
    L_0x02d6:
        r2 = r1;
        goto L_0x021c;
    L_0x02d9:
        super.dispatchTouchEvent(r12);	 Catch:{ NullPointerException -> 0x009b, IllegalArgumentException -> 0x00d2, ArrayIndexOutOfBoundsException -> 0x0149 }
        goto L_0x000c;
    L_0x02de:
        r2 = r3;
        goto L_0x01cf;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.SwipeBackLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        if (this.FU != null) {
            this.FU.layout(this.uHX, this.uHY, this.uHX + this.FU.getMeasuredWidth(), this.uHY + this.FU.getMeasuredHeight());
        }
        this.mInLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.FU ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.zj, 0.0f) <= 0 || obj == null || this.uHZ.Cu == 0)) {
            Rect rect = this.ea;
            view.getHitRect(rect);
            this.uIb.setBounds(rect.left - this.uIb.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.uIb.setAlpha((int) (this.zj * 255.0f));
            this.uIb.draw(canvas);
        }
        return drawChild;
    }

    public void computeScroll() {
        this.zj = Math.max(0.0f, 1.0f - this.uIa);
        com.tencent.mm.ui.mogic.a aVar = this.uHZ;
        if (aVar.Cu == 2) {
            boolean computeScrollOffset = aVar.fT.computeScrollOffset();
            int currX = aVar.fT.getCurrX();
            int currY = aVar.fT.getCurrY();
            int left = currX - aVar.CI.getLeft();
            int top = currY - aVar.CI.getTop();
            if (left != 0) {
                aVar.CI.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.CI.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.uuI.fd(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.fT.getFinalX() && currY == aVar.fT.getFinalY()) {
                aVar.fT.abortAnimation();
                computeScrollOffset = aVar.fT.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.CK.post(aVar.CL);
            }
        }
        if ((aVar.Cu == 2 ? 1 : null) != null) {
            z.E(this);
        }
    }

    public void setSwipeGestureDelegate(a aVar) {
        this.uIk = aVar;
    }
}
