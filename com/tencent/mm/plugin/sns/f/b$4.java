package com.tencent.mm.plugin.sns.f;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$4 implements AnimationListener {
    final /* synthetic */ b ntP;

    b$4(b bVar) {
        this.ntP = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.ntP.ntB = true;
    }

    public final void onAnimationEnd(Animation animation) {
        this.ntP.ntB = false;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
