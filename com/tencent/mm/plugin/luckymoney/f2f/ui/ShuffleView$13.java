package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$13 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$13(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            ShuffleView.b(this.kPn).clear();
            ShuffleView.c(this.kPn).clear();
            for (int i = 0; i < ShuffleView.d(this.kPn); i++) {
                ShuffleView.b(this.kPn).add(Float.valueOf(((View) ShuffleView.e(this.kPn).get(i)).getTranslationX()));
                ShuffleView.c(this.kPn).add(Float.valueOf(((View) ShuffleView.e(this.kPn).get(i)).getTranslationY()));
            }
            return;
        }
        ((View) ShuffleView.e(this.kPn).get(0)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(0)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(0) * floatValue));
        ((View) ShuffleView.e(this.kPn).get(0)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(0)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(0) * floatValue));
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 < ShuffleView.d(this.kPn)) {
                ((View) ShuffleView.e(this.kPn).get(i3)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i3)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i3) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i3)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i3)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i3) * floatValue));
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
