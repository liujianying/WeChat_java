package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class e$8 implements AnimatorListener {
    final /* synthetic */ e olJ;

    e$8(e eVar) {
        this.olJ = eVar;
    }

    public final void onAnimationStart(Animator animator) {
        e.b(this.olJ);
    }

    public final void onAnimationEnd(Animator animator) {
        this.olJ.olC.setVisibility(4);
        this.olJ.olC.setTranslationY(0.0f);
    }

    public final void onAnimationCancel(Animator animator) {
        this.olJ.olC.setVisibility(4);
        this.olJ.olC.setTranslationY(0.0f);
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
