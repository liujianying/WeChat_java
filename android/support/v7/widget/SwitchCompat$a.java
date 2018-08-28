package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwitchCompat$a extends Animation {
    final /* synthetic */ SwitchCompat Wj;
    final float Wk;
    final float Wl;
    final float Wm;

    /* synthetic */ SwitchCompat$a(SwitchCompat switchCompat, float f, float f2, byte b) {
        this(switchCompat, f, f2);
    }

    private SwitchCompat$a(SwitchCompat switchCompat, float f, float f2) {
        this.Wj = switchCompat;
        this.Wk = f;
        this.Wl = f2;
        this.Wm = f2 - f;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        SwitchCompat.a(this.Wj, this.Wk + (this.Wm * f));
    }
}
