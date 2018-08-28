package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.a.h.a;

class h$5 implements AnimationListener {
    final /* synthetic */ float bCl;
    final /* synthetic */ float bCm;
    final /* synthetic */ View nVj;
    final /* synthetic */ View nVk;
    final /* synthetic */ int nVm;
    final /* synthetic */ View oI;
    final /* synthetic */ h okk;
    final /* synthetic */ a okl;

    public h$5(h hVar, View view, View view2, a aVar, View view3, int i, float f, float f2) {
        this.okk = hVar;
        this.nVj = view;
        this.nVk = view2;
        this.okl = aVar;
        this.oI = view3;
        this.nVm = i;
        this.bCl = f;
        this.bCm = f2;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.nVj.setVisibility(0);
        this.nVk.setVisibility(8);
        h.b(this.okl.oko);
        com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.oI.getContext(), (float) this.nVm, 0.0f, this.bCl, this.bCm, false);
        aVar.setDuration(187);
        aVar.setInterpolator(new DecelerateInterpolator());
        aVar.setFillAfter(true);
        this.oI.startAnimation(aVar);
    }
}
