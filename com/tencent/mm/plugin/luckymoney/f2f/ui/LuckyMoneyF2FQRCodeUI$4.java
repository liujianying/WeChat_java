package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyF2FQRCodeUI$4 implements a {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$4(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void a(ValueAnimator valueAnimator, View view) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            LuckyMoneyF2FQRCodeUI.a(this.kOv, view.getTranslationX());
            LuckyMoneyF2FQRCodeUI.b(this.kOv, view.getTranslationY());
            view.findViewById(f.lucky_money_f2f_single_card).setVisibility(0);
        }
        view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.A(this.kOv));
        view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.B(this.kOv)) - ((((float) LuckyMoneyF2FQRCodeUI.c(this.kOv).getHeight()) + (LuckyMoneyF2FQRCodeUI.B(this.kOv) * 8.0f)) * floatValue));
        view.setScaleX((0.5f * floatValue) + 1.0f);
        view.setScaleY((0.5f * floatValue) + 1.0f);
        Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.f(this.kOv).peek();
        if (!(pair == null || bi.oW(LuckyMoneyF2FQRCodeUI.C(this.kOv)) || !LuckyMoneyF2FQRCodeUI.C(this.kOv).equals(pair.first))) {
            LuckyMoneyF2FQRCodeUI.D(this.kOv).setAlpha(floatValue);
        }
        x.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[]{Float.valueOf(floatValue)});
        if (floatValue >= 0.9f) {
            view.setAlpha((1.0f - floatValue) * 10.0f);
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setScaleX(floatValue);
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setScaleY(floatValue);
            LuckyMoneyF2FQRCodeUI.E(this.kOv).setVisibility(0);
        }
        if (floatValue == 1.0f) {
            LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("packet_received.m4a");
            LuckyMoneyF2FQRCodeUI.c(this.kOv).removeView(LuckyMoneyF2FQRCodeUI.c(this.kOv).getExitView());
            LuckyMoneyF2FQRCodeUI.G(this.kOv);
            LuckyMoneyF2FQRCodeUI.H(this.kOv).start();
        }
    }
}
