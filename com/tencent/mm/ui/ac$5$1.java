package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.ac.5;

class ac$5$1 implements AnimationListener {
    final /* synthetic */ 5 tpx;

    ac$5$1(5 5) {
        this.tpx = 5;
    }

    public final void onAnimationStart(Animation animation) {
        ac.a(this.tpx.tpr);
        this.tpx.tpr.v(false, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ac.b(this.tpx.tpr);
    }
}
