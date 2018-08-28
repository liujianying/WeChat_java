package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.t.a;

class a$1 implements AnimatorUpdateListener {
    Matrix bwq = new Matrix(this.bws.bwh.getMainMatrix());
    Rect bwr = new Rect(this.bws.bwl);
    final /* synthetic */ a bws;

    a$1(a aVar) {
        this.bws = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
        float floatValue3 = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
        float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
        this.bws.bwn.reset();
        this.bws.bwn.postTranslate(floatValue2, floatValue);
        RectF rectF = new RectF(this.bwr);
        this.bws.bwn.mapRect(rectF);
        rectF.round(this.bws.bwl);
        this.bws.bwn.postScale(floatValue3, floatValue3, (float) this.bws.bwl.centerX(), (float) this.bws.bwl.centerY());
        Matrix matrix = new Matrix(this.bwq);
        matrix.postConcat(this.bws.bwn);
        this.bws.bwh.getMainMatrix().set(matrix);
        a aVar = this.bws.bwh.bBH;
        a.gt((int) floatValue4);
        RectF rectF2 = new RectF(this.bwr);
        this.bws.bwn.mapRect(rectF2);
        rectF2.round(this.bws.bwl);
        this.bws.bwh.vO();
    }
}
