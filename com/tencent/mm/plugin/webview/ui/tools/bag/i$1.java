package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class i$1 implements AnimatorUpdateListener {
    final /* synthetic */ i qbX;

    i$1(i iVar) {
        this.qbX = iVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        i.a(this.qbX, ((Integer) valueAnimator.getAnimatedValue("canvasTranslationX")).intValue());
        i.a(this.qbX).left = (float) ((Integer) valueAnimator.getAnimatedValue("translationX")).intValue();
        i.a(this.qbX).top = (float) ((Integer) valueAnimator.getAnimatedValue("translationY")).intValue();
        i.a(this.qbX).right = (((Float) valueAnimator.getAnimatedValue("scaleX")).floatValue() * ((float) i.b(this.qbX))) + i.a(this.qbX).left;
        i.a(this.qbX).bottom = (((Float) valueAnimator.getAnimatedValue("scaleY")).floatValue() * ((float) i.c(this.qbX))) + i.a(this.qbX).top;
        this.qbX.postInvalidate();
    }
}
