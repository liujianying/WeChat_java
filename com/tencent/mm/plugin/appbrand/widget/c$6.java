package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c$6 extends AnimatorListenerAdapter {
    final /* synthetic */ c gEs;
    final /* synthetic */ Runnable gna;

    c$6(c cVar, Runnable runnable) {
        this.gEs = cVar;
        this.gna = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.gna != null) {
            this.gEs.post(this.gna);
        }
    }
}
