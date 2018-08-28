package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class n$10 extends AnimatorListenerAdapter {
    final /* synthetic */ n gmP;
    final /* synthetic */ Runnable gna;

    n$10(n nVar, Runnable runnable) {
        this.gmP = nVar;
        this.gna = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.gna != null) {
            this.gna.run();
        }
    }
}
