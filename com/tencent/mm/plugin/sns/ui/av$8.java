package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class av$8 implements AnimationListener {
    final /* synthetic */ av ocj;

    av$8(av avVar) {
        this.ocj = avVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.ocj.obY != null) {
            this.ocj.obY.clearAnimation();
            this.ocj.obY.setVisibility(8);
        }
        this.ocj.obY = null;
    }
}
