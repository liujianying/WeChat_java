package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$12 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;
    final /* synthetic */ int kPp;
    final /* synthetic */ int kPq;

    ShuffleView$12(ShuffleView shuffleView, int i, int i2) {
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
                if (i2 >= ShuffleView.i(this.kPn)) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i2) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i = i2 + 1;
            }
        } else {
            while (true) {
                i2 = i;
                if (i2 >= ShuffleView.i(this.kPn) - 1) {
                    break;
                }
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(i2) - (((float) (i2 + 1)) * ShuffleView.j(this.kPn))) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i = i2 + 1;
            }
            ((View) ShuffleView.e(this.kPn).get(ShuffleView.i(this.kPn) - 1)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(ShuffleView.i(this.kPn) - 1)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(ShuffleView.i(this.kPn) - 1) - ((ShuffleView.j(this.kPn) * ((float) this.kPp)) / 2.0f)) * floatValue));
        }
        int i3;
        if (this.kPq > 0) {
            ShuffleView.k(this.kPn).setTranslationX((((Float) ShuffleView.b(this.kPn).get(ShuffleView.i(this.kPn))).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(ShuffleView.i(this.kPn)) + ((ShuffleView.j(this.kPn) * ((float) this.kPq)) / 2.0f)) * floatValue));
            ShuffleView.k(this.kPn).setTranslationY((((Float) ShuffleView.c(this.kPn).get(ShuffleView.i(this.kPn))).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(ShuffleView.i(this.kPn)) * floatValue));
            i3 = ShuffleView.i(this.kPn) + 1;
            while (true) {
                i2 = i3;
                if (i2 < ShuffleView.d(this.kPn)) {
                    ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.kPn.sb(i2) + (((float) (ShuffleView.d(this.kPn) - i2)) * ShuffleView.j(this.kPn))) * floatValue));
                    ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                    i3 = i2 + 1;
                } else {
                    return;
                }
            }
        }
        i3 = ShuffleView.i(this.kPn);
        while (true) {
            i2 = i3;
            if (i2 < ShuffleView.d(this.kPn)) {
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationX((((Float) ShuffleView.b(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sb(i2) * floatValue));
                ((View) ShuffleView.e(this.kPn).get(i2)).setTranslationY((((Float) ShuffleView.c(this.kPn).get(i2)).floatValue() * (1.0f - floatValue)) + (this.kPn.sc(i2) * floatValue));
                i3 = i2 + 1;
            } else {
                return;
            }
        }
    }
}
