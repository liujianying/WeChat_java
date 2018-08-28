package com.tencent.mm.ui.contact;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SelectContactUI$10 implements AnimationListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$10(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        SelectContactUI.l(this.ulL).setVisibility(8);
    }
}
