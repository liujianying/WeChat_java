package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$2 implements AnimatorListener {
    final /* synthetic */ c qfw;

    c$2(c cVar) {
        this.qfw = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.qfw.isAnimating = true;
        if (this.qfw.qfh != null) {
            this.qfw.qfh.onAnimationStart();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        this.qfw.isAnimating = false;
        if (this.qfw.qfh != null) {
            this.qfw.qfh.onAnimationEnd();
        }
        this.qfw.qfc.setVisibility(0);
        this.qfw.qfd.setAlpha(1.0f);
        this.qfw.qfd.setVisibility(8);
        this.qfw.qeY.setAlpha(1.0f);
        this.qfw.qeY.setVisibility(8);
    }

    public final void onAnimationCancel(Animator animator) {
        this.qfw.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
