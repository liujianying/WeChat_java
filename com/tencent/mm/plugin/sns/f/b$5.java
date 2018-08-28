package com.tencent.mm.plugin.sns.f;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$5 implements AnimationListener {
    final /* synthetic */ b ntP;
    final /* synthetic */ View ntQ;

    b$5(b bVar, View view) {
        this.ntP = bVar;
        this.ntQ = view;
    }

    public final void onAnimationStart(Animation animation) {
        this.ntP.ntB = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.ntQ != null) {
            this.ntQ.clearAnimation();
            this.ntQ.setVisibility(8);
            this.ntP.bzf();
        }
        this.ntP.ntB = false;
    }
}
