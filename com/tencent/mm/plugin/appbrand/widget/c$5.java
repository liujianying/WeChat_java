package com.tencent.mm.plugin.appbrand.widget;

import android.animation.ObjectAnimator;

class c$5 implements Runnable {
    final /* synthetic */ c gEs;
    final /* synthetic */ ObjectAnimator gEu;

    public c$5(c cVar, ObjectAnimator objectAnimator) {
        this.gEs = cVar;
        this.gEu = objectAnimator;
    }

    public final void run() {
        this.gEs.setVisibility(0);
        c.a(this.gEs, this.gEu);
    }
}
