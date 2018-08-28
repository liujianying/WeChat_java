package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$1 implements AnimationListener {
    final /* synthetic */ a maB;
    final /* synthetic */ View val$view;

    a$1(a aVar, View view) {
        this.maB = aVar;
        this.val$view = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.val$view.startAnimation(a.a(this.maB));
    }
}
