package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class MMSightRecordButton$4 extends AnimatorListenerAdapter {
    final /* synthetic */ MMSightRecordButton loJ;
    final /* synthetic */ AnimatorListenerAdapter loL;

    MMSightRecordButton$4(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
        this.loJ = mMSightRecordButton;
        this.loL = animatorListenerAdapter;
    }

    public final void onAnimationStart(Animator animator) {
        MMSightRecordButton.a(this.loJ, true);
        if (this.loL != null) {
            this.loL.onAnimationStart(animator);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        MMSightRecordButton.a(this.loJ, false);
        if (this.loL != null) {
            this.loL.onAnimationEnd(animator);
        }
    }
}
