package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DynamicGridView$10 extends AnimatorListenerAdapter {
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$10(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    public final void onAnimationStart(Animator animator) {
        DynamicGridView.b(this.omz, true);
        DynamicGridView.b(this.omz);
    }

    public final void onAnimationEnd(Animator animator) {
        DynamicGridView.b(this.omz, false);
        DynamicGridView.b(this.omz);
    }
}
