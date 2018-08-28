package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ak {

    /* renamed from: android.support.v4.view.ak$1 */
    static class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$view;
        final /* synthetic */ am xn;

        AnonymousClass1(am amVar, View view) {
            this.xn = amVar;
            this.val$view = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.xn.ar(this.val$view);
        }

        public final void onAnimationEnd(Animator animator) {
            this.xn.q(this.val$view);
        }

        public final void onAnimationStart(Animator animator) {
            this.xn.p(this.val$view);
        }
    }
}
