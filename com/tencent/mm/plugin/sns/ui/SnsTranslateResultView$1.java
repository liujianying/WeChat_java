package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;

class SnsTranslateResultView$1 implements AnimatorListener {
    final /* synthetic */ b ofE;
    final /* synthetic */ SnsTranslateResultView ofF;

    SnsTranslateResultView$1(SnsTranslateResultView snsTranslateResultView, b bVar) {
        this.ofF = snsTranslateResultView;
        this.ofE = bVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.ofE != null) {
            ap.a(this.ofE);
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
