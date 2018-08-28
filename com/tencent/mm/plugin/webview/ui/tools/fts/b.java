package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

public final class b extends a {
    public b(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                b.this.qeW = layoutParams.leftMargin - b.this.lvk;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                b.this.qeV = (int) view6.getX();
                return true;
            }
        });
    }

    public final void AZ(int i) {
        aa(i, true);
    }

    public final void aa(int i, boolean z) {
        if (i != this.qfg) {
            switch (6.qfp[i - 1]) {
                case 1:
                    bXC();
                    return;
                case 2:
                    if (z) {
                        bXD();
                        return;
                    }
                    this.qeY.setAlpha(0.0f);
                    this.qfc.setVisibility(0);
                    this.qfa.setAlpha(1.0f);
                    this.qfa.setVisibility(8);
                    this.qfb.setAlpha(1.0f);
                    this.qeX.setPadding(this.qeW, 0, 0, 0);
                    int i2 = this.qeT;
                    LayoutParams layoutParams = (LayoutParams) this.qeX.getLayoutParams();
                    layoutParams.leftMargin = this.qeT - i2;
                    layoutParams.rightMargin = this.qeT - i2;
                    layoutParams.width = (i2 * 2) + ((int) this.qff[2][0]);
                    this.qeX.setLayoutParams(layoutParams);
                    this.qeX.post(new 4(this));
                    return;
                default:
                    return;
            }
        }
    }

    protected final void bXC() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.qff[0][0] - ((float) this.qeU) >= 0.0f) {
            ofFloat.addUpdateListener(this.qfk);
        } else {
            ofFloat.addUpdateListener(this.qfl);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.qfe, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.qeY, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.qfa, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat4, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                b.this.isAnimating = true;
                if (b.this.qfh != null) {
                    b.this.qfh.onAnimationStart();
                }
                b.this.qfa.setVisibility(0);
                b.this.qeY.setVisibility(0);
                b.this.qfc.setVisibility(8);
                b.this.qfb.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                b.this.isAnimating = false;
                if (b.this.qfh != null) {
                    b.this.qfh.onAnimationEnd();
                }
                b.this.qeZ.setVisibility(0);
                b.this.qeX.setPadding(0, 0, 0, 0);
                b.this.qfb.setAlpha(1.0f);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bXD() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.qff[0][0] - ((float) this.qeU) >= 0.0f) {
            ofFloat.addUpdateListener(this.qfi);
        } else {
            ofFloat.addUpdateListener(this.qfj);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.qfe, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.qeY, "alpha", new float[]{1.0f, 0.0f});
        this.qfa.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new 5(this));
        animatorSet.start();
    }
}
