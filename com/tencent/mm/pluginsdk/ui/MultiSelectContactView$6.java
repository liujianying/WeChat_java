package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MultiSelectContactView$6 implements AnimationListener {
    final /* synthetic */ MultiSelectContactView qGe;
    final /* synthetic */ View val$view;

    MultiSelectContactView$6(MultiSelectContactView multiSelectContactView, View view) {
        this.qGe = multiSelectContactView;
        this.val$view = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.val$view.post(new 1(this));
    }
}
