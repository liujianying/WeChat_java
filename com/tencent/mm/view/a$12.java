package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$12 implements AnimationListener {
    final /* synthetic */ a uSy;

    a$12(a aVar) {
        this.uSy = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.uSy.getActionBar().setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
