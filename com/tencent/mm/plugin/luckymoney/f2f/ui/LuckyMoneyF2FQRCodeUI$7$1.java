package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7;

class LuckyMoneyF2FQRCodeUI$7$1 implements AnimatorUpdateListener {
    final /* synthetic */ 7 kOD;

    LuckyMoneyF2FQRCodeUI$7$1(7 7) {
        this.kOD = 7;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.N(this.kOD.kOv).setPadding(LuckyMoneyF2FQRCodeUI.N(this.kOD.kOv).getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.N(this.kOD.kOv).getPaddingRight(), LuckyMoneyF2FQRCodeUI.N(this.kOD.kOv).getPaddingBottom());
        floatValue /= (float) this.kOD.kOB;
        if (floatValue <= 1.0f) {
            LuckyMoneyF2FQRCodeUI.P(this.kOD.kOv).setAlpha((1.0f - floatValue) + LuckyMoneyF2FQRCodeUI.O(this.kOD.kOv));
            LuckyMoneyF2FQRCodeUI.Q(this.kOD.kOv).setAlpha(floatValue * LuckyMoneyF2FQRCodeUI.O(this.kOD.kOv));
            return;
        }
        LuckyMoneyF2FQRCodeUI.P(this.kOD.kOv).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.kOD.kOv));
        LuckyMoneyF2FQRCodeUI.Q(this.kOD.kOv).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.kOD.kOv));
    }
}
