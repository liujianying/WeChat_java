package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$1 implements AnimatorListener {
    final /* synthetic */ c qfw;

    c$1(c cVar) {
        this.qfw = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.qfw.isAnimating = true;
        if (this.qfw.qfh != null) {
            this.qfw.qfh.onAnimationStart();
        }
        this.qfw.qfa.setVisibility(0);
        this.qfw.qeY.setVisibility(0);
        this.qfw.qfc.setVisibility(8);
        this.qfw.qfd.setVisibility(0);
        this.qfw.qfb.setVisibility(8);
    }

    public final void onAnimationEnd(Animator animator) {
        this.qfw.isAnimating = false;
        if (this.qfw.qfh != null) {
            this.qfw.qfh.onAnimationEnd();
        }
    }

    public final void onAnimationCancel(Animator animator) {
        this.qfw.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
