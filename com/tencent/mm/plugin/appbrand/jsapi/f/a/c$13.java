package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.m;
import com.tencent.mm.sdk.platformtools.x;

class c$13 implements AnimatorListener {
    final /* synthetic */ c fTi;
    final /* synthetic */ m fTq;

    public c$13(c cVar, m mVar) {
        this.fTi = cVar;
        this.fTq = mVar;
    }

    public final void onAnimationStart(Animator animator) {
        x.d("MicroMSg.AppBrandMapView", "MarkerAnimator start");
    }

    public final void onAnimationEnd(Animator animator) {
        x.d("MicroMSg.AppBrandMapView", "MarkerAnimator end");
        if (this.fTq != null) {
            this.fTq.cR(true);
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
