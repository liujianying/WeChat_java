package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.u.e.b;

class w$1 implements AnimatorUpdateListener {
    final /* synthetic */ b iZ;
    final /* synthetic */ w ja;

    w$1(w wVar, b bVar) {
        this.ja = wVar;
        this.iZ = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.iZ.aO();
    }
}
