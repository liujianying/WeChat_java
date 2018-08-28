package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class d$4 implements AnimatorListener {
    final /* synthetic */ d qfx;

    d$4(d dVar) {
        this.qfx = dVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.qfx.isAnimating = true;
        if (this.qfx.qfh != null) {
            this.qfx.qfh.onAnimationStart();
        }
        this.qfx.qeZ.setVisibility(8);
        this.qfx.qfb.setVisibility(0);
    }

    public final void onAnimationEnd(Animator animator) {
        this.qfx.isAnimating = false;
        if (this.qfx.qfh != null) {
            this.qfx.qfh.onAnimationEnd();
        }
        this.qfx.qfc.setVisibility(0);
        this.qfx.qfa.setAlpha(1.0f);
        this.qfx.qfa.setVisibility(8);
    }

    public final void onAnimationCancel(Animator animator) {
        this.qfx.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
