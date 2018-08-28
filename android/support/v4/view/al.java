package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class al {

    /* renamed from: android.support.v4.view.al$1 */
    static class AnonymousClass1 implements AnimatorUpdateListener {
        final /* synthetic */ View val$view;
        final /* synthetic */ ao xo;

        AnonymousClass1(ao aoVar, View view) {
            this.xo = aoVar;
            this.val$view = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.xo.cn();
        }
    }
}
