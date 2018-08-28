package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$18 implements Runnable {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$18(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void run() {
        if (SightCaptureUI.e(this.lqr) != 4) {
            x.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
            SightCaptureUI.g(this.lqr, 9);
        }
    }
}
