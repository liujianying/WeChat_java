package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class DynamicGridView$3 extends AnimatorListenerAdapter {
    final /* synthetic */ View gvo;
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$3(DynamicGridView dynamicGridView, View view) {
        this.omz = dynamicGridView;
        this.gvo = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.gvo.setLayerType(0, null);
    }
}
