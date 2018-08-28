package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$6 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$6(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.H(this.lqr).setVisibility(8);
    }
}
