package com.tencent.mm.plugin.setting.ui.setting;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class UnfamiliarContactDetailUI$12 implements AnimationListener {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$12(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        UnfamiliarContactDetailUI.l(this.mUT).setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
