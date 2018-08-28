package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.view.b.a;

public final class d extends b {
    public a bwB;
    public float bwC;
    public float bwD;
    public boolean bwE = true;
    public boolean bwF = false;
    public ValueAnimator bwg;
    public float dD = 1.0f;

    /* renamed from: com.tencent.mm.b.d$1 */
    class AnonymousClass1 implements AnimatorUpdateListener {
        int bwG = 0;
        float bwH = ((float) Math.pow((double) (d.this.dD / this.bwI), 0.25d));
        final /* synthetic */ float bwI;
        float bwy = 0.0f;
        float bwz = 0.0f;

        public AnonymousClass1(float f) {
            this.bwI = f;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.bwG < 4 && d.this.bwE) {
                d.this.bwB.getMainMatrix().postScale(this.bwH, this.bwH);
                this.bwG++;
            }
            RectF curImageRect = d.this.bwB.getCurImageRect();
            Rect boardRect = d.this.bwB.getBoardRect();
            if (d.this.bwF) {
                if (curImageRect.top > ((float) boardRect.top)) {
                    f = ((float) boardRect.top) - curImageRect.top;
                } else {
                    f = 0.0f;
                }
                if (curImageRect.right < ((float) boardRect.right)) {
                    f2 = ((float) boardRect.right) - curImageRect.right;
                }
                if (curImageRect.bottom < ((float) boardRect.bottom)) {
                    f = ((float) boardRect.bottom) - curImageRect.bottom;
                }
                if (curImageRect.left > ((float) boardRect.left)) {
                    f2 = ((float) boardRect.left) - curImageRect.left;
                }
            } else {
                d dVar = d.this;
                dVar.bwC += floatValue2 - this.bwz;
                dVar = d.this;
                dVar.bwD += floatValue - this.bwy;
                f2 = d.this.bwC - curImageRect.centerX();
                f = d.this.bwD - curImageRect.centerY();
            }
            d.this.bwB.getMainMatrix().postTranslate(f2, f);
            d.this.bwB.postInvalidate();
            this.bwy = floatValue;
            this.bwz = floatValue2;
        }
    }

    public d(a aVar) {
        this.bwB = aVar;
    }
}
