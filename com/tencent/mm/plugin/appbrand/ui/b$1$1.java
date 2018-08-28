package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.ui.b.1;

class b$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewParent gut;
    final /* synthetic */ 1 guu;

    b$1$1(1 1, ViewParent viewParent) {
        this.guu = 1;
        this.gut = viewParent;
    }

    public final void onAnimationEnd(Animator animator) {
        this.guu.gus.setVisibility(8);
        ((ViewGroup) this.gut).removeView(this.guu.gus);
    }
}
