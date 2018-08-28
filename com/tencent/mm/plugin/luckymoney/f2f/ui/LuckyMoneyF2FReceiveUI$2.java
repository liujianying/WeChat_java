package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LuckyMoneyF2FReceiveUI$2 implements AnimatorUpdateListener {
    final /* synthetic */ LuckyMoneyF2FReceiveUI kON;

    LuckyMoneyF2FReceiveUI$2(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.kON = luckyMoneyF2FReceiveUI;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LuckyMoneyF2FReceiveUI.c(this.kON).setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.b(this.kON).heightPixels));
    }
}
