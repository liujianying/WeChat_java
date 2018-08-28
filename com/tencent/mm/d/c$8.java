package com.tencent.mm.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;

class c$8 implements AnimatorUpdateListener {
    final /* synthetic */ c bCc;
    int bCe = 0;
    float bCf;
    float bCg = 0.0f;
    float bCh;
    float bCi = 0.0f;
    float bCj = this.bCl;
    float bCk = this.bCm;
    final /* synthetic */ float bCl;
    final /* synthetic */ float bCm;
    final /* synthetic */ float bCn;
    int bwG = 0;
    float bwH = ((float) Math.pow((double) this.bCn, 0.0833333358168602d));

    public c$8(c cVar, float f, float f2, float f3) {
        this.bCc = cVar;
        this.bCl = f;
        this.bCm = f2;
        this.bCn = f3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.bwG < 12) {
            this.bCc.getMainMatrix().postScale(this.bwH, this.bwH, ((float) c.d(this.bCc).centerX()) + this.bCg, ((float) c.d(this.bCc).centerY()) + this.bCi);
            c.e(this.bCc).postScale(this.bwH, this.bwH, ((float) c.d(this.bCc).centerX()) + this.bCg, ((float) c.d(this.bCc).centerY()) + this.bCi);
            this.bwG++;
        }
        int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
        this.bCc.getMainMatrix().postRotate((float) (intValue - this.bCe), this.bCl + this.bCg, this.bCm + this.bCi);
        c.e(this.bCc).postRotate((float) (intValue - this.bCe), this.bCl + this.bCg, this.bCm + this.bCi);
        RectF rectF = new RectF();
        rectF.set(c.d(this.bCc));
        c.e(this.bCc).mapRect(rectF);
        this.bCj += ((float) intValue2) - this.bCf;
        this.bCk += ((float) intValue3) - this.bCh;
        this.bCg = this.bCj - rectF.centerX();
        this.bCi = this.bCk - rectF.centerY();
        this.bCc.getMainMatrix().postTranslate(this.bCg, this.bCi);
        c.e(this.bCc).postTranslate(this.bCg, this.bCi);
        this.bCc.vO();
        this.bCe = intValue;
        this.bCf = (float) intValue2;
        this.bCh = (float) intValue3;
    }
}
