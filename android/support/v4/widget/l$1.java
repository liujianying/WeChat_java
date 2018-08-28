package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class l$1 extends Animation {
    final /* synthetic */ l$a Ai;
    final /* synthetic */ l Aj;

    l$1(l lVar, l$a l_a) {
        this.Aj = lVar;
        this.Ai = l_a;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        if (this.Aj.Ah) {
            l.b(f, this.Ai);
            return;
        }
        float b = l.b(this.Ai);
        float f2 = this.Ai.As;
        float f3 = this.Ai.Ar;
        float f4 = this.Ai.At;
        l.c(f, this.Ai);
        if (f <= 0.5f) {
            float f5 = 0.8f - b;
            this.Ai.D(f3 + (l.cJ().getInterpolation(f / 0.5f) * f5));
        }
        if (f > 0.5f) {
            this.Ai.E(((0.8f - b) * l.cJ().getInterpolation((f - 0.5f) / 0.5f)) + f2);
        }
        this.Ai.setRotation((0.25f * f) + f4);
        this.Aj.setRotation((216.0f * f) + (1080.0f * (l.a(this.Aj) / 5.0f)));
    }
}
