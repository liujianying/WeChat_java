package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.sns.ui.b.b;

class b$1 implements AnimatorListener {
    final /* synthetic */ b nKk;
    final /* synthetic */ b nKl;

    b$1(b bVar, b bVar2) {
        this.nKl = bVar;
        this.nKk = bVar2;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.nKk != null) {
            this.nKk.onAnimationStart();
        }
        this.nKl.nKj = this.nKl.nKg;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.nKk != null) {
            this.nKk.onAnimationEnd();
        }
        this.nKl.nKj = this.nKl.nKh;
    }

    public final void onAnimationCancel(Animator animator) {
        this.nKl.nKj = this.nKl.nKh;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
