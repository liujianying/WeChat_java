package com.tencent.mm.plugin.facedetect.d;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ah;

class d$4 implements AnimationListener {
    final /* synthetic */ d iPx;

    d$4(d dVar) {
        this.iPx = dVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ah.i(new 1(this), 500);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
