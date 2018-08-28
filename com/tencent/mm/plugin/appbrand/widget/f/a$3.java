package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a$3 extends AnimatorListenerAdapter {
    final /* synthetic */ a gOP;

    a$3(a aVar) {
        this.gOP = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.gOP.setVisibility(8);
        a.b(this.gOP);
    }

    public final void onAnimationCancel(Animator animator) {
        a.b(this.gOP);
    }
}
