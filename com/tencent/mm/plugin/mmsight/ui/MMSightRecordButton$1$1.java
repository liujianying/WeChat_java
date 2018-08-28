package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ 1 loK;

    MMSightRecordButton$1$1(1 1) {
        this.loK = 1;
    }

    public final void onAnimationEnd(Animator animator) {
        x.l("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
        if (this.loK.loI != null) {
            this.loK.loI.bfd();
        }
    }
}
