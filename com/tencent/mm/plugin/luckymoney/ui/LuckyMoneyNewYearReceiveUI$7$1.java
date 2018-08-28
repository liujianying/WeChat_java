package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7;
import com.tencent.mm.plugin.wxpay.a.i;

class LuckyMoneyNewYearReceiveUI$7$1 implements AnimationListener {
    final /* synthetic */ 7 kWm;

    LuckyMoneyNewYearReceiveUI$7$1(7 7) {
        this.kWm = 7;
    }

    public final void onAnimationStart(Animation animation) {
        LuckyMoneyNewYearReceiveUI.j(this.kWm.kWg).setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (g.AT().getInt("PlayCoinSound", 0) > 0) {
            k.I(this.kWm.kWg, i.lucky_cashrecivedrevised);
        }
        if (this.kWm.kWl.kMP != null) {
            this.kWm.kWl.kMP.b(this.kWm.kWg, null, null);
        }
    }
}
