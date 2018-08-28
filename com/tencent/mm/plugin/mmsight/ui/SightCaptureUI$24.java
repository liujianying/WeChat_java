package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$24 implements d {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$24(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void bfj() {
        x.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[]{bi.cjd().toString()});
        if (SightCaptureUI.n(this.lqr) != null) {
            x.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[]{SightCaptureUI.n(this.lqr).ben()});
            SightCaptureUI.n(this.lqr).cancel();
        }
        com.tencent.mm.plugin.mmsight.d.Hp("TIME_RECODER_2_PLAY");
        SightCaptureUI.o(this.lqr);
    }
}
