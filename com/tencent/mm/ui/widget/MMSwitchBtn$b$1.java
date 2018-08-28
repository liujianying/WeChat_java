package com.tencent.mm.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.widget.MMSwitchBtn.b;

class MMSwitchBtn$b$1 implements AnimationListener {
    final /* synthetic */ MMSwitchBtn uHd;
    final /* synthetic */ b uHe;

    MMSwitchBtn$b$1(b bVar, MMSwitchBtn mMSwitchBtn) {
        this.uHe = bVar;
        this.uHd = mMSwitchBtn;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        boolean z = true;
        if (MMSwitchBtn.a(this.uHe.uHc) != (this.uHe.direction == 1)) {
            MMSwitchBtn mMSwitchBtn = this.uHe.uHc;
            if (this.uHe.direction != 1) {
                z = false;
            }
            MMSwitchBtn.a(mMSwitchBtn, z);
            this.uHe.uHc.post(new 1(this));
        }
        MMSwitchBtn.c(this.uHe.uHc);
    }
}
