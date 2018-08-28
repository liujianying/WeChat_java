package android.support.v4.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.a.f.b;

class f$b$1 implements AnimatorUpdateListener {
    final /* synthetic */ d mo;
    final /* synthetic */ b mp;

    f$b$1(b bVar, d dVar) {
        this.mp = bVar;
        this.mo = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.mo.b(this.mp);
    }
}
