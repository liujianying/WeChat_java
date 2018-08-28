package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DynamicGridView$6 extends AnimatorListenerAdapter {
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$6(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    public final void onAnimationStart(Animator animator) {
        DynamicGridView.a(this.omz, true);
        DynamicGridView.b(this.omz);
    }

    public final void onAnimationEnd(Animator animator) {
        DynamicGridView.a(this.omz, false);
        DynamicGridView.b(this.omz);
    }
}
