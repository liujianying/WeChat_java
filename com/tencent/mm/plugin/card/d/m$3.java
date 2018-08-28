package com.tencent.mm.plugin.card.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

class m$3 implements AnimationListener {
    final /* synthetic */ View hIO;
    final /* synthetic */ ScaleAnimation hIP;

    public m$3(View view, ScaleAnimation scaleAnimation) {
        this.hIO = view;
        this.hIP = scaleAnimation;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.hIO.startAnimation(this.hIP);
    }
}
