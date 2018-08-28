package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class c$15 implements AnimationListener {
    final /* synthetic */ c kJf;
    final /* synthetic */ boolean kJg;

    c$15(c cVar, boolean z) {
        this.kJf = cVar;
        this.kJg = z;
    }

    public final void onAnimationStart(Animation animation) {
        x.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", Long.valueOf(System.currentTimeMillis()));
        c.c(this.kJf, false);
        c.a(this.kJf, true);
    }

    public final void onAnimationEnd(Animation animation) {
        c.c(this.kJf, true);
        if (this.kJg) {
            this.kJf.rT(c.d(this.kJf));
            c.d(this.kJf, true);
        } else {
            this.kJf.rT(c.e(this.kJf));
            c.d(this.kJf, false);
        }
        c.s(this.kJf).clearAnimation();
        c.l(this.kJf).clearAnimation();
        c.t(this.kJf).clearAnimation();
        c.c(this.kJf).clearFocus();
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
