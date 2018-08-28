package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$14 implements a {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$14(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void beR() {
        x.i("MicroMsg.SightCaptureUI", "on video edit finish");
        if (SightCaptureUI.O(this.lqr) != null) {
            SightCaptureUI.a(this.lqr, bi.aG(SightCaptureUI.O(this.lqr).bKg, ""));
            SightCaptureUI.O(this.lqr).l(false, SightCaptureUI.a(this.lqr).leu);
            SightCaptureUI.O(this.lqr).release();
            SightCaptureUI.P(this.lqr);
        }
        SightCaptureUI.G(this.lqr).setVisibility(0);
        SightCaptureUI.Q(this.lqr).setVisibility(0);
        SightCaptureUI.R(this.lqr).setVisibility(0);
        SightCaptureUI.S(this.lqr).stop();
        SightCaptureUI.S(this.lqr).setVideoPath(SightCaptureUI.n(this.lqr).getFilePath());
        SightCaptureUI.S(this.lqr).setLoop(true);
        SightCaptureUI.S(this.lqr).setForceScaleFullScreen(true);
        SightCaptureUI.S(this.lqr).setVideoCallback(SightCaptureUI.T(this.lqr));
        this.lqr.DO(8);
        e.post(new 1(this), "SightCaptureUI_edit_finish_save_new_thumb");
        SightCaptureUI.V(this.lqr);
    }

    public final void beS() {
        x.i("MicroMsg.SightCaptureUI", "on video edit exit");
        if (SightCaptureUI.O(this.lqr) != null) {
            SightCaptureUI.O(this.lqr).l(true, SightCaptureUI.a(this.lqr).leu);
            SightCaptureUI.O(this.lqr).release();
            SightCaptureUI.P(this.lqr);
        }
        this.lqr.DO(8);
        SightCaptureUI.G(this.lqr).setVisibility(0);
        SightCaptureUI.Q(this.lqr).setVisibility(0);
        SightCaptureUI.R(this.lqr).setVisibility(0);
    }

    public final void onError() {
        x.i("MicroMsg.SightCaptureUI", "on video edit error");
        if (SightCaptureUI.O(this.lqr) != null) {
            SightCaptureUI.O(this.lqr).release();
            SightCaptureUI.P(this.lqr);
        }
        ah.A(new 2(this));
    }
}
