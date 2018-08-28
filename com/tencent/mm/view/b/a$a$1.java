package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.view.b.a.a;

class a$a$1 implements AnimatorUpdateListener {
    int bwG = 0;
    float bwH = ((float) Math.pow((double) this.uUt.dD, 0.10000000149011612d));
    float bwy = 0.0f;
    float bwz = 0.0f;
    float uUs = 0.0f;
    final /* synthetic */ a uUt;

    a$a$1(a aVar) {
        this.uUt = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
        float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
        if (this.bwG < 10) {
            this.uUt.uUn.bBo.postScale(this.bwH, this.bwH, (float) this.uUt.uUn.getBoardRect().centerX(), (float) this.uUt.uUn.getBoardRect().centerY());
            this.bwG++;
        }
        this.uUt.bwC += floatValue2 - this.bwz;
        this.uUt.bwD += floatValue - this.bwy;
        this.uUt.uUn.bBo.postTranslate(this.uUt.bwC - this.uUt.uUn.getCurImageRect().centerX(), this.uUt.bwD - this.uUt.uUn.getCurImageRect().centerY());
        if (this.uUt.cY != 0.0f) {
            this.uUt.uUn.bBo.postRotate(floatValue3 - this.uUs, this.uUt.bwC, this.uUt.bwD);
        }
        this.uUt.uUn.postInvalidate();
        this.bwy = floatValue;
        this.bwz = floatValue2;
        this.uUs = floatValue3;
    }
}
