package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

final class f implements c {
    private TimeInterpolator mk;

    f() {
    }

    public final g bb() {
        return new b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public final void v(View view) {
        if (this.mk == null) {
            this.mk = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.mk);
    }
}
