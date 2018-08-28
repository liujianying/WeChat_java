package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class b$2 extends AnimatorListenerAdapter {
    final /* synthetic */ b lry;

    b$2(b bVar) {
        this.lry = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.lry.lrk = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.lry.lrk = true;
        if (this.lry.lrl != null) {
            this.lry.lrl.a(this.lry.lrj);
        }
    }
}
