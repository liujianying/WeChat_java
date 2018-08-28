package com.tencent.mm.ui.widget.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.widget.a.c.1;

class c$1$1 implements AnimationListener {
    final /* synthetic */ 1 uJK;

    c$1$1(1 1) {
        this.uJK = 1;
    }

    public final void onAnimationStart(Animation animation) {
        c.a(this.uJK.uJJ, c.d(this.uJK.uJJ));
    }

    public final void onAnimationEnd(Animation animation) {
        c.c(this.uJK.uJJ).setVisibility(8);
        c.a(this.uJK.uJJ, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
