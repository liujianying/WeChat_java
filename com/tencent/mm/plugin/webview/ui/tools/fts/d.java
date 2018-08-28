package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import org.xwalk.core.Log;

public final class d extends a {
    public d(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new 1(this, view2));
        view6.getViewTreeObserver().addOnPreDrawListener(new 2(this, view6));
    }

    protected final void bXC() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "search to init");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.qff[0][0] - ((float) this.qeU) >= 0.0f) {
            ofFloat.addUpdateListener(this.qfk);
        } else {
            ofFloat.addUpdateListener(this.qfl);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.qeY, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.qfa, "alpha", new float[]{0.0f, 1.0f});
        this.qfb.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                d.this.isAnimating = true;
                if (d.this.qfh != null) {
                    d.this.qfh.onAnimationStart();
                }
                d.this.qfa.setVisibility(0);
                d.this.qeY.setVisibility(0);
                d.this.qfc.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                d.this.isAnimating = false;
                if (d.this.qfh != null) {
                    d.this.qfh.onAnimationEnd();
                }
                d.this.qeZ.setVisibility(0);
                d.this.qeX.setPadding(0, 0, 0, 0);
                d.this.qfb.setAlpha(1.0f);
                d.this.qfb.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bXD() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "init to search");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.qff[0][0] - ((float) this.qeU) >= 0.0f) {
            ofFloat.addUpdateListener(this.qfi);
        } else {
            ofFloat.addUpdateListener(this.qfj);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.qeY, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.qfa, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.qfb, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        animatorSet.setDuration(300);
        animatorSet.addListener(new 4(this));
        animatorSet.start();
    }
}
