package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Animation;

class sr$2 extends sp {
    private /* synthetic */ sr a;

    sr$2(sr srVar) {
        this.a = srVar;
    }

    public final void onAnimationEnd(Animation animation) {
        sr.g(this.a).setAnimationListener(null);
        sr.h(this.a);
    }
}
