package com.tencent.mm.plugin.luckymoney.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.List;

public class ConfettiView extends View implements OnLayoutChangeListener {
    List<b> kRX;
    private boolean kSH;
    private b kSI;
    boolean terminated;

    public static ConfettiView dN(Context context) {
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(d.confetti_default_elevation));
        }
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTouchEnabled(boolean z) {
        this.kSH = z;
    }

    public final void bbe() {
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.kRX == null) {
            bbe();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.terminated) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (b bVar : this.kRX) {
                if (bVar.kTe) {
                    bVar.a(canvas, bVar.kTg + bVar.kTi, bVar.kTh + bVar.kTj, bVar.kTc);
                } else if (bVar.kTd && !bVar.terminated) {
                    bVar.a(canvas, bVar.kTa, bVar.kTb, bVar.kTc);
                }
            }
            canvas.restore();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = r8.kSH;
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r9.getAction();
        switch(r0) {
            case 0: goto L_0x0018;
            case 1: goto L_0x009b;
            case 2: goto L_0x0081;
            case 3: goto L_0x009b;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r1;
    L_0x000e:
        if (r0 != 0) goto L_0x0016;
    L_0x0010:
        r0 = super.onTouchEvent(r9);
        if (r0 == 0) goto L_0x00e7;
    L_0x0016:
        r0 = r2;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r8.kRX;
        r4 = r0.iterator();
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x007f;
    L_0x0024:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.luckymoney.particles.a.b) r0;
        r5 = r9.getX();
        r6 = r9.getY();
        r3 = r0.kTa;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0038:
        r3 = r0.kTa;
        r7 = r0.getWidth();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0044:
        r3 = r0.kTb;
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x004a:
        r3 = r0.kTb;
        r7 = r0.getHeight();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0056:
        r3 = r2;
    L_0x0057:
        if (r3 == 0) goto L_0x007d;
    L_0x0059:
        r0.kTe = r2;
        r0.kTg = r5;
        r0.kTh = r6;
        r3 = r0.kTa;
        r3 = r3 - r5;
        r0.kTi = r3;
        r3 = r0.kTb;
        r3 = r3 - r6;
        r0.kTj = r3;
        r3 = android.view.VelocityTracker.obtain();
        r0.kTf = r3;
        r3 = r0.kTf;
        r3.addMovement(r9);
        r3 = r2;
    L_0x0075:
        if (r3 == 0) goto L_0x001e;
    L_0x0077:
        r8.kSI = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x007b:
        r3 = r1;
        goto L_0x0057;
    L_0x007d:
        r3 = r1;
        goto L_0x0075;
    L_0x007f:
        r0 = r1;
        goto L_0x000e;
    L_0x0081:
        r0 = r8.kSI;
        if (r0 == 0) goto L_0x000d;
    L_0x0085:
        r0 = r8.kSI;
        r3 = r9.getX();
        r0.kTg = r3;
        r3 = r9.getY();
        r0.kTh = r3;
        r0 = r0.kTf;
        r0.addMovement(r9);
        r0 = r2;
        goto L_0x000e;
    L_0x009b:
        r0 = r8.kSI;
        if (r0 == 0) goto L_0x000d;
    L_0x009f:
        r0 = r8.kSI;
        r3 = r0.kTf;
        r3.addMovement(r9);
        r3 = r0.kTf;
        r3.computeCurrentVelocity(r2);
        r4 = -1;
        r0.kSO = r4;
        r3 = r9.getX();
        r4 = r0.kTi;
        r3 = r3 + r4;
        r0.kSP = r3;
        r3 = r9.getY();
        r4 = r0.kTj;
        r3 = r3 + r4;
        r0.kSQ = r3;
        r3 = r0.kTf;
        r3 = r3.getXVelocity();
        r0.kSR = r3;
        r3 = r0.kTf;
        r3 = r3.getYVelocity();
        r0.kSS = r3;
        r3 = r0.kTc;
        r0.kSV = r3;
        r3 = r0.kTf;
        r3.recycle();
        r3 = r0.kSe;
        r0.i(r3);
        r0.kTe = r1;
        r0 = 0;
        r8.kSI = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x00e7:
        r0 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.particles.ConfettiView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
