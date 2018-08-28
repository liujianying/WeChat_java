package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$13 implements AnimationListener {
    final /* synthetic */ a uSy;

    a$13(a aVar) {
        this.uSy = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.uSy.getFooterBg().setVisibility(0);
        this.uSy.getActionBar().setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
