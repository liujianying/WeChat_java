package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.R;

class ThrowBottleAnimUI$3 implements AnimationListener {
    final /* synthetic */ ThrowBottleAnimUI hnb;

    ThrowBottleAnimUI$3(ThrowBottleAnimUI throwBottleAnimUI) {
        this.hnb = throwBottleAnimUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ThrowBottleAnimUI.b(this.hnb).setVisibility(8);
        if (ThrowBottleAnimUI.i(this.hnb) == null) {
            ThrowBottleAnimUI.a(this.hnb, (SprayLayout) ThrowBottleAnimUI.a(this.hnb).findViewById(R.h.bottle_spray_fl));
        }
        ThrowBottleAnimUI.i(this.hnb).E(1, ThrowBottleAnimUI.j(this.hnb), ThrowBottleAnimUI.k(this.hnb));
        ThrowBottleAnimUI.l(this.hnb).sendEmptyMessageDelayed(0, 2000);
    }
}
