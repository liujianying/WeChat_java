package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LuckyMoneyF2FQRCodeUI$6 implements AnimatorUpdateListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$6(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.E(this.kOv).setTranslationY((-0.5f * floatValue) * ((float) LuckyMoneyF2FQRCodeUI.K(this.kOv).heightPixels));
        LuckyMoneyF2FQRCodeUI.D(this.kOv).setAlpha(1.0f - floatValue);
        if (floatValue == 1.0f) {
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setVisibility(8);
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setTranslationY(0.0f);
            LuckyMoneyF2FQRCodeUI.L(this.kOv);
            LuckyMoneyF2FQRCodeUI.M(this.kOv).notifyDataSetChanged();
            LuckyMoneyF2FQRCodeUI.w(this.kOv).Eh(0);
        }
    }
}
