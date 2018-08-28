package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;

class b$1 extends AnimatorListenerAdapter {
    final /* synthetic */ b fPK;
    final /* synthetic */ f fPe;

    b$1(b bVar, f fVar) {
        this.fPK = bVar;
        this.fPe = fVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.fPe.tp(this.fPK.f("ok", null));
    }
}
