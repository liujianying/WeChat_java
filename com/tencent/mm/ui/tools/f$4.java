package com.tencent.mm.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements AnimationListener {
    final /* synthetic */ f$b uzV;
    final /* synthetic */ f uzW;

    f$4(f fVar, f$b f_b) {
        this.uzW = fVar;
        this.uzV = f_b;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (this.uzV != null) {
            this.uzV.onAnimationStart();
        }
        this.uzW.nKj = this.uzW.nKi;
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (this.uzV != null) {
            this.uzV.onAnimationEnd();
        }
        this.uzW.nKj = this.uzW.nKf;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
