package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DynamicGridView$5 implements AnimatorUpdateListener {
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$5(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.omz.invalidate();
    }
}
