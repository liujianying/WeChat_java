package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$3 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;
    final /* synthetic */ int kPo;

    ShuffleView$3(ShuffleView shuffleView, int i) {
        this.kPn = shuffleView;
        this.kPo = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.kPo;
        while (true) {
            int i2 = i;
            if (i2 < ShuffleView.d(this.kPn) - 1) {
                View view = (View) ShuffleView.e(this.kPn).get(i2);
                if (ShuffleView.l(this.kPn).kPr == 1) {
                    view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.kPn).scaleX) + (1.0f - (ShuffleView.l(this.kPn).scaleX * ((float) (i2 + 1)))));
                    if (ShuffleView.l(this.kPn).kPs == 2) {
                        view.setTranslationY(this.kPn.sc(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.kPn)));
                    } else if (ShuffleView.l(this.kPn).kPs == 1) {
                        view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.kPn)) + this.kPn.sc(i2 + 1));
                    }
                } else if (ShuffleView.l(this.kPn).kPr == 2) {
                    view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.kPn).scaleY) + (1.0f - (ShuffleView.l(this.kPn).scaleY * ((float) (i2 + 1)))));
                    if (ShuffleView.l(this.kPn).kPs == 3) {
                        view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.kPn)) + this.kPn.sb(i2 + 1));
                    } else if (ShuffleView.l(this.kPn).kPs == 4) {
                        view.setTranslationX(this.kPn.sb(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.kPn)));
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
