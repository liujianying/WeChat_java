package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

class sr$4 extends sp {
    final /* synthetic */ View a;
    final /* synthetic */ sr b;

    sr$4(sr srVar, View view) {
        this.b = srVar;
        this.a = view;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new 1(this));
    }
}
