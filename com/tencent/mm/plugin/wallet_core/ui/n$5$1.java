package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.wallet_core.ui.n.5;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class n$5$1 implements AnimationListener {
    final /* synthetic */ 5 pxR;

    n$5$1(5 5) {
        this.pxR = 5;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
        ah.A(new 1(this));
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
        ah.A(new 2(this));
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
