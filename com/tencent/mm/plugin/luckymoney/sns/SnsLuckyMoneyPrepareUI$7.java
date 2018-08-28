package com.tencent.mm.plugin.luckymoney.sns;

import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.plugin.wxpay.a.f;

class SnsLuckyMoneyPrepareUI$7 implements Runnable {
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$7(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.kTy = snsLuckyMoneyPrepareUI;
    }

    public final void run() {
        SnsLuckyMoneyPrepareUI.l(this.kTy).setVisibility(0);
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(800);
        scaleAnimation.setStartOffset(200);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        this.kTy.findViewById(f.lucky_money_prepare_ready_packet_ll).startAnimation(scaleAnimation);
    }
}
