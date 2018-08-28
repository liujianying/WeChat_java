package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.plugin.luckymoney.b.o;

class LuckyMoneyNewYearSendUI$3 implements LuckyMoneyAutoScrollView$a {
    final /* synthetic */ LuckyMoneyNewYearSendUI kWx;

    LuckyMoneyNewYearSendUI$3(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        this.kWx = luckyMoneyNewYearSendUI;
    }

    public final void bbn() {
        if (LuckyMoneyNewYearSendUI.s(this.kWx)) {
            LuckyMoneyNewYearSendUI.t(this.kWx).setVisibility(4);
            o.a(this.kWx.mController.tml, LuckyMoneyNewYearSendUI.t(this.kWx), LuckyMoneyNewYearSendUI.u(this.kWx));
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(new 1(this));
            LuckyMoneyNewYearSendUI.t(this.kWx).startAnimation(alphaAnimation);
            LuckyMoneyNewYearSendUI.v(this.kWx);
            return;
        }
        o.a(this.kWx.mController.tml, LuckyMoneyNewYearSendUI.t(this.kWx), LuckyMoneyNewYearSendUI.u(this.kWx));
        LuckyMoneyNewYearSendUI.t(this.kWx).invalidate();
    }
}
