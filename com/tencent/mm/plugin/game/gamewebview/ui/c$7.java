package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c$7 extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable gna;
    final /* synthetic */ c jIM;

    c$7(c cVar, Runnable runnable) {
        this.jIM = cVar;
        this.gna = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.gna != null) {
            this.gna.run();
        }
    }
}
