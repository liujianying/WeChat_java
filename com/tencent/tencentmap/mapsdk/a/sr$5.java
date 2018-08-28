package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.animation.Animation;

class sr$5 extends sp {
    final /* synthetic */ sr a;

    sr$5(sr srVar) {
        this.a = srVar;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new 1(this));
    }
}
