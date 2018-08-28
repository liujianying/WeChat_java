package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$11 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$11(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = 0;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            ShuffleView.b(this.kPn).clear();
            ShuffleView.c(this.kPn).clear();
            while (i < ShuffleView.d(this.kPn)) {
                ShuffleView.b(this.kPn).add(Float.valueOf(((View) ShuffleView.e(this.kPn).get(i)).getTranslationX()));
                ShuffleView.c(this.kPn).add(Float.valueOf(((View) ShuffleView.e(this.kPn).get(i)).getTranslationY()));
                i++;
            }
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < ShuffleView.d(this.kPn)) {
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i2) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
