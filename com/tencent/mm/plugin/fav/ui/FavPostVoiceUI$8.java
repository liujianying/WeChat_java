package com.tencent.mm.plugin.fav.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FavPostVoiceUI$8 implements AnimationListener {
    final /* synthetic */ FavPostVoiceUI iZn;

    FavPostVoiceUI$8(FavPostVoiceUI favPostVoiceUI) {
        this.iZn = favPostVoiceUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FavPostVoiceUI.l(this.iZn).post(new 1(this));
    }
}
