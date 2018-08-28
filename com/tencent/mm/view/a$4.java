package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$4 implements AnimationListener {
    final /* synthetic */ a uSy;

    a$4(a aVar) {
        this.uSy = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        a.d(this.uSy).setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
