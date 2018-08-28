package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$9 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;
    final /* synthetic */ int kPp;
    final /* synthetic */ int kPq;

    ShuffleView$9(ShuffleView shuffleView, int i, int i2) {
        this.kPn = shuffleView;
        this.kPp = i;
        this.kPq = i2;
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
        int i2;
        if (this.kPp <= 0) {
            while (true) {
                i2 = i;
                if (i2 >= ShuffleView.f(this.kPn)) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i2) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i = i2 + 1;
            }
        } else {
            while (true) {
                i2 = i;
                if (i2 >= ShuffleView.f(this.kPn) - 1) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(i2) - (((float) (i2 + 1)) * ShuffleView.g(this.kPn))) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i = i2 + 1;
            }
            ((View) ShuffleView.e(this.kPn).get(ShuffleView.f(this.kPn) - 1)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(ShuffleView.f(this.kPn) - 1)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(ShuffleView.f(this.kPn) - 1) - ((ShuffleView.g(this.kPn) * ((float) this.kPp)) / 2.0f)) * floatValue));
            ((View) ShuffleView.e(this.kPn).get(ShuffleView.f(this.kPn) - 1)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(ShuffleView.f(this.kPn) - 1)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(ShuffleView.f(this.kPn) - 1) * floatValue));
        }
        int f;
        if (this.kPq <= 0) {
            f = ShuffleView.f(this.kPn);
            while (true) {
                i2 = f;
                if (i2 >= ShuffleView.d(this.kPn)) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i2) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                f = i2 + 1;
            }
        } else {
            ShuffleView.h(this.kPn).setTranslationX((((Float) ShuffleView.b(this.kPn).get(ShuffleView.f(this.kPn))).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(ShuffleView.f(this.kPn)) + ((ShuffleView.g(this.kPn) * ((float) this.kPq)) / 2.0f)) * floatValue));
            f = ShuffleView.f(this.kPn) + 1;
            while (true) {
                i2 = f;
                if (i2 >= ShuffleView.d(this.kPn)) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(i2) + (((float) (ShuffleView.d(this.kPn) - i2)) * ShuffleView.g(this.kPn))) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                f = i2 + 1;
            }
        }
        ShuffleView.h(this.kPn).setTranslationY((((Float) ShuffleView.c(this.kPn).get(ShuffleView.f(this.kPn))).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.h(this.kPn).getHeight()) * floatValue) / 7.0f));
    }
}
