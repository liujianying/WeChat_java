package com.tencent.mm.plugin.webview.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class b$2 implements AnimatorUpdateListener {
    final /* synthetic */ b pOa;
    final /* synthetic */ LayoutParams pOb;
    final /* synthetic */ View pOc;
    final /* synthetic */ LayoutParams pOd;
    final /* synthetic */ View pOe;

    b$2(b bVar, LayoutParams layoutParams, View view, LayoutParams layoutParams2, View view2) {
        this.pOa = bVar;
        this.pOb = layoutParams;
        this.pOc = view;
        this.pOd = layoutParams2;
        this.pOe = view2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.pOb.height = intValue;
        this.pOc.setLayoutParams(this.pOb);
        this.pOd.height = intValue;
        this.pOe.setLayoutParams(this.pOd);
    }
}
