package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ah;

class b$5 implements AnimationListener {
    final /* synthetic */ b nhT;

    b$5(b bVar) {
        this.nhT = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.nhT.nhR = true;
    }

    public final void onAnimationEnd(Animation animation) {
        ah.A(new Runnable() {
            public final void run() {
                b$5.this.nhT.bwH();
            }
        });
        this.nhT.nhR = false;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
