package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class e$3 extends AnimatorListenerAdapter {
    final /* synthetic */ h fdi;
    final /* synthetic */ e gFZ;
    final /* synthetic */ View gGa;

    e$3(e eVar, View view, h hVar) {
        this.gFZ = eVar;
        this.gGa = view;
        this.fdi = hVar;
    }

    public final void onAnimationCancel(Animator animator) {
        onAnimationEnd(animator);
    }

    public final void onAnimationEnd(Animator animator) {
        this.gGa.setVisibility(8);
        this.gFZ.removeView(this.gGa);
        e.b(this.gFZ).remove(this.fdi);
        e.c(this.gFZ);
    }
}
