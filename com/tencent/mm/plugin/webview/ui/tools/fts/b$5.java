package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class b$5 implements AnimatorListener {
    final /* synthetic */ b qfu;

    b$5(b bVar) {
        this.qfu = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.qfu.isAnimating = true;
        if (this.qfu.qfh != null) {
            this.qfu.qfh.onAnimationStart();
        }
        this.qfu.qeZ.setVisibility(8);
        this.qfu.qfb.setVisibility(0);
    }

    public final void onAnimationEnd(Animator animator) {
        this.qfu.isAnimating = false;
        if (this.qfu.qfh != null) {
            this.qfu.qfh.onAnimationEnd();
        }
        this.qfu.qfc.setVisibility(0);
        this.qfu.qfa.setAlpha(1.0f);
        this.qfu.qfa.setVisibility(8);
    }

    public final void onAnimationCancel(Animator animator) {
        this.qfu.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
