package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class i$2 extends AnimatorListenerAdapter {
    final /* synthetic */ i qbX;

    i$2(i iVar) {
        this.qbX = iVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (i.d(this.qbX) != null) {
            i.d(this.qbX).onAnimationEnd(animator);
        }
        this.qbX.setVisibility(8);
        if (i.e(this.qbX) != null && !i.e(this.qbX).isRecycled()) {
            i.e(this.qbX).recycle();
        }
    }
}
