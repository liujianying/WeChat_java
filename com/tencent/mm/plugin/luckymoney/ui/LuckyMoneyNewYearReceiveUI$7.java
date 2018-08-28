package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.o;

class LuckyMoneyNewYearReceiveUI$7 implements LuckyMoneyAutoScrollView$a {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;
    final /* synthetic */ ad kWl;

    LuckyMoneyNewYearReceiveUI$7(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, ad adVar) {
        this.kWg = luckyMoneyNewYearReceiveUI;
        this.kWl = adVar;
    }

    public final void bbn() {
        LuckyMoneyNewYearReceiveUI.j(this.kWg).setVisibility(4);
        o.a(this.kWg.mController.tml, LuckyMoneyNewYearReceiveUI.j(this.kWg), this.kWl.kQP.kLf);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(new 1(this));
        LuckyMoneyNewYearReceiveUI.j(this.kWg).startAnimation(alphaAnimation);
    }
}
