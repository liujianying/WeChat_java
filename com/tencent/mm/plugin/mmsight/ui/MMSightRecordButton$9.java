package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$9 extends AnimatorListenerAdapter {
    final /* synthetic */ MMSightRecordButton loJ;
    final /* synthetic */ long loM;

    MMSightRecordButton$9(MMSightRecordButton mMSightRecordButton, long j) {
        this.loJ = mMSightRecordButton;
        this.loM = j;
    }

    public final void onAnimationEnd(Animator animator) {
        if (MMSightRecordButton.g(this.loJ) > 0 && this.loM <= 500) {
            x.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(MMSightRecordButton.a(this.loJ)), Boolean.valueOf(MMSightRecordButton.b(this.loJ))});
            MMSightRecordButton.h(this.loJ);
            if (!MMSightRecordButton.b(this.loJ) && MMSightRecordButton.i(this.loJ) != null) {
                MMSightRecordButton.i(this.loJ).bfj();
            }
        } else if (MMSightRecordButton.b(this.loJ)) {
            x.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
            if (MMSightRecordButton.d(this.loJ) != null) {
                MMSightRecordButton.d(this.loJ).bfi();
            }
        } else {
            x.i("MicroMsg.MMSightRecordButton", "error action up");
            if (MMSightRecordButton.j(this.loJ) != null) {
                MMSightRecordButton.j(this.loJ).bff();
            }
        }
    }
}
