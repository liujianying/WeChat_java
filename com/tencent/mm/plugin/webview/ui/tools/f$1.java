package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class f$1 extends AnimatorListenerAdapter {
    final /* synthetic */ f pXu;

    f$1(f fVar) {
        this.pXu = fVar;
    }

    public final void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        f.a(this.pXu);
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        f.a(this.pXu);
    }
}
