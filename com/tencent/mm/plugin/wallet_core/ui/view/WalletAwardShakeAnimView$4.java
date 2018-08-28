package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class WalletAwardShakeAnimView$4 implements AnimatorUpdateListener {
    final /* synthetic */ WalletAwardShakeAnimView pzP;

    WalletAwardShakeAnimView$4(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        this.pzP = walletAwardShakeAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        WalletAwardShakeAnimView.j(this.pzP).setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
