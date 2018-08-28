package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public final class g {
    private int gGb;
    public ValueAnimator gGc;
    View view;

    public g(View view) {
        this.view = view;
    }

    public final void c(int i, final Runnable runnable) {
        if (this.view != null) {
            this.gGb = i;
            if ((this.view.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.view.getBackground()).getColor() == i) {
                if (runnable != null) {
                    runnable.run();
                }
                if (this.gGc != null) {
                    this.gGc.cancel();
                    return;
                }
                return;
            }
            AnimatorListener anonymousClass1 = new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    g.this.gGc = null;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    g.this.gGc = null;
                }
            };
            if (this.gGc != null && this.gGc.isStarted() && this.gGc.isRunning() && this.gGb == i) {
                this.gGc.addListener(anonymousClass1);
                return;
            }
            if (this.gGc != null) {
                this.gGc.cancel();
            }
            int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
            this.gGc = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.gGb)});
            this.gGc.addListener(anonymousClass1);
            this.gGc.addUpdateListener(new 2(this));
            this.gGc.start();
        }
    }
}
