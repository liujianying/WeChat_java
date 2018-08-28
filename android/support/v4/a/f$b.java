package android.support.v4.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

class f$b implements g {
    final Animator mn;

    public f$b(Animator animator) {
        this.mn = animator;
    }

    public final void w(View view) {
        this.mn.setTarget(view);
    }

    public final void a(b bVar) {
        this.mn.addListener(new f$a(bVar, this));
    }

    public final void setDuration(long j) {
        this.mn.setDuration(j);
    }

    public final void start() {
        this.mn.start();
    }

    public final void cancel() {
        this.mn.cancel();
    }

    public final void a(d dVar) {
        if (this.mn instanceof ValueAnimator) {
            ((ValueAnimator) this.mn).addUpdateListener(new 1(this, dVar));
        }
    }

    public final float getAnimatedFraction() {
        return ((ValueAnimator) this.mn).getAnimatedFraction();
    }
}
