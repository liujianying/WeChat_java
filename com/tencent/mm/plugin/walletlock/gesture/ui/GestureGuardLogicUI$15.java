package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;

class GestureGuardLogicUI$15 implements AnimationListener {
    final /* synthetic */ GestureGuardLogicUI pHr;
    final /* synthetic */ a pHu;

    GestureGuardLogicUI$15(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.pHr = gestureGuardLogicUI;
        this.pHu = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        GestureGuardLogicUI.q(this.pHr).setAnimationListener(null);
        if (this.pHu != null) {
            this.pHu.onDone();
        }
    }
}
