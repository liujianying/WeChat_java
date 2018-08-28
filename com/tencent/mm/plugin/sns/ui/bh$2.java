package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bh$2 implements AnimationListener {
    final /* synthetic */ View ntQ;
    final /* synthetic */ bh ohO;

    bh$2(bh bhVar, View view) {
        this.ohO = bhVar;
        this.ntQ = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.ntQ != null) {
            this.ntQ.setVisibility(8);
            this.ohO.bCa();
        }
    }
}
