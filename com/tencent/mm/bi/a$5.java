package com.tencent.mm.bi;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$5 implements AnimationListener {
    final /* synthetic */ a qVu;

    a$5(a aVar) {
        this.qVu = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.qVu.qVl.getRubbishView().setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
