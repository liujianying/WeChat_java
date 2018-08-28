package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$15 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$15(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.G(this.lqr).setEnabled(true);
    }

    public final void onAnimationStart(Animator animator) {
        SightCaptureUI.G(this.lqr).setEnabled(false);
    }
}
