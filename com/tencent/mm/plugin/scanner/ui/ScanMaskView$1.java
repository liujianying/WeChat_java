package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanMaskView$1 implements AnimatorUpdateListener {
    final /* synthetic */ ScanMaskView mKg;

    ScanMaskView$1(ScanMaskView scanMaskView) {
        this.mKg = scanMaskView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ScanMaskView.a(this.mKg).left = ScanMaskView.b(this.mKg).left + ((int) (ScanMaskView.c(this.mKg) * floatValue));
        ScanMaskView.a(this.mKg).right = ScanMaskView.b(this.mKg).right + ((int) (ScanMaskView.d(this.mKg) * floatValue));
        ScanMaskView.a(this.mKg).top = ScanMaskView.b(this.mKg).top + ((int) (ScanMaskView.e(this.mKg) * floatValue));
        ScanMaskView.a(this.mKg).bottom = ((int) (floatValue * ScanMaskView.f(this.mKg))) + ScanMaskView.b(this.mKg).bottom;
        this.mKg.invalidate();
    }
}
