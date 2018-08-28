package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$16 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$16(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.Q(this.lqr).setEnabled(true);
    }

    public final void onAnimationStart(Animator animator) {
        SightCaptureUI.Q(this.lqr).setEnabled(false);
    }
}
