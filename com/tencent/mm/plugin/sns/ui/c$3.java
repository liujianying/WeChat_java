package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class c$3 implements AnimationListener {
    final /* synthetic */ c nKx;
    final /* synthetic */ View ntQ;

    c$3(c cVar, View view) {
        this.nKx = cVar;
        this.ntQ = view;
    }

    public final void onAnimationStart(Animation animation) {
        this.nKx.ntB = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.ntQ != null) {
            this.ntQ.clearAnimation();
            this.ntQ.setVisibility(8);
            this.nKx.bzf();
        }
        this.nKx.ntB = false;
    }
}
