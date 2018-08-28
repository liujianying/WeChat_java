package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.w.a.b;
import com.tencent.mm.w.a.g;

public final class i {

    public interface a {
        void bWQ();

        void onAnimationEnd();
    }

    @TargetApi(11)
    public static final void m(View view, float f) {
        if (view != null && !d.fS(11)) {
            Animator animator = (Animator) view.getTag(g.property_anim);
            if (animator != null) {
                animator.cancel();
            }
            view.setScaleX(f);
            view.setScaleY(f);
        }
    }

    @TargetApi(14)
    public static final void n(View view, float f) {
        if (view != null && !d.fS(14)) {
            Animator animator = (Animator) view.getTag(g.property_anim);
            if (animator != null) {
                animator.cancel();
            }
            view.animate().cancel();
            view.setTranslationX(f);
            view.setTranslationY(0.0f);
        }
    }

    @TargetApi(14)
    public static final void a(View view, long j, float f, final a aVar) {
        if (view != null && !d.fS(14)) {
            Animator animator = (Animator) view.getTag(g.property_anim);
            if (animator != null) {
                animator.cancel();
            }
            view.animate().cancel();
            if (aVar == null) {
                view.animate().setDuration(j).translationX(f).translationY(0.0f);
            } else {
                view.animate().setDuration(j).translationX(f).translationY(0.0f).setListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        aVar.onAnimationEnd();
                    }

                    public final void onAnimationCancel(Animator animator) {
                        aVar.bWQ();
                    }
                });
            }
        }
    }

    @TargetApi(14)
    public static final void a(View view, long j, float f, float f2) {
        if (view != null && !d.fS(14)) {
            Animator animator = (Animator) view.getTag(g.property_anim);
            if (animator != null) {
                animator.cancel();
            }
            view.animate().cancel();
            view.animate().setListener(null);
            view.animate().setDuration(j).translationX(f).translationY(0.0f).setInterpolator(new AccelerateInterpolator(f2));
        }
    }

    @TargetApi(11)
    public static void a(View view, AnimatorListener animatorListener) {
        if (view != null && !d.fS(11)) {
            Animator animator = (Animator) view.getTag(g.property_anim);
            if (animator != null) {
                animator.cancel();
            }
            animator = AnimatorInflater.loadAnimator(view.getContext(), b.fade_in_property_anim);
            animator.setTarget(view);
            if (animatorListener != null) {
                animator.addListener(animatorListener);
            }
            animator.start();
            view.setTag(g.property_anim, animator);
        }
    }
}
