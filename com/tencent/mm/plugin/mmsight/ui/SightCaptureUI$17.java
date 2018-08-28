package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$17 implements Runnable {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$17(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void run() {
        if (SightCaptureUI.e(this.lqr) == 7 && SightCaptureUI.i(this.lqr) != null) {
            x.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
            MMSightRecordButton i = SightCaptureUI.i(this.lqr);
            x.i("MicroMsg.MMSightRecordButton", "showProgressBar");
            i.lop.setVisibility(0);
        }
    }
}
