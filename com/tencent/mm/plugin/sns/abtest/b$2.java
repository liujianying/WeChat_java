package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$2 implements AnimationListener {
    final /* synthetic */ b nhT;

    b$2(b bVar) {
        this.nhT = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.nhT.nhR = true;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.nhT.nhD != null) {
            this.nhT.nhD.setVisibility(0);
        }
        this.nhT.nhR = false;
        this.nhT.nhP = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
