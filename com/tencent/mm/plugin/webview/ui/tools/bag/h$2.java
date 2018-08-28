package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class h$2 extends AnimatorListenerAdapter {
    final /* synthetic */ e qbG;

    h$2(e eVar) {
        this.qbG = eVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.qbG.onAnimationEnd();
    }
}
