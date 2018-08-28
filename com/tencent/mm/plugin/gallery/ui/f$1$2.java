package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.ui.f.1;

class f$1$2 implements AnimationListener {
    final /* synthetic */ 1 jEw;

    f$1$2(1 1) {
        this.jEw = 1;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        a.swap(f.d(this.jEw.jEt), f.e(this.jEw.jEt), f.f(this.jEw.jEt));
        if (f.a(this.jEw.jEt) == null) {
            return;
        }
        if (this.jEw.ccQ > f.e(this.jEw.jEt) && this.jEw.ccQ <= f.f(this.jEw.jEt)) {
            f.a(this.jEw.jEt).K(f.e(this.jEw.jEt), f.f(this.jEw.jEt), this.jEw.ccQ - 1);
        } else if (this.jEw.ccQ < f.e(this.jEw.jEt) && this.jEw.ccQ >= f.f(this.jEw.jEt)) {
            f.a(this.jEw.jEt).K(f.e(this.jEw.jEt), f.f(this.jEw.jEt), this.jEw.ccQ + 1);
        } else if (f.e(this.jEw.jEt) == this.jEw.ccQ) {
            f.a(this.jEw.jEt).K(f.e(this.jEw.jEt), f.f(this.jEw.jEt), f.f(this.jEw.jEt));
        } else {
            f.a(this.jEw.jEt).K(f.e(this.jEw.jEt), f.f(this.jEw.jEt), this.jEw.ccQ);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
