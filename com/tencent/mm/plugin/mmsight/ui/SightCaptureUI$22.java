package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$22 implements MMSightRecordButton$a {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$22(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void bff() {
        x.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[]{bi.cjd().toString()});
        if (SightCaptureUI.n(this.lqr) != null) {
            SightCaptureUI.n(this.lqr).cancel();
            if (SightCaptureUI.j(this.lqr) == 0) {
                SightCaptureUI.o(this.lqr);
            }
        }
    }
}
