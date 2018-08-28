package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TrackPointAnimAvatar$2 implements AnimationListener {
    final /* synthetic */ TrackPointAnimAvatar kKr;

    TrackPointAnimAvatar$2(TrackPointAnimAvatar trackPointAnimAvatar) {
        this.kKr = trackPointAnimAvatar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.kKr.bringToFront();
        TrackPointAnimAvatar.b(this.kKr).startAnimation(TrackPointAnimAvatar.c(this.kKr));
    }
}
