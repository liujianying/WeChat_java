package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$19 implements a {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$19(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.lqr.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void iy() {
        if (SightCaptureUI.S(this.lqr) != null) {
            SightCaptureUI.S(this.lqr).start();
            SightCaptureUI.S(this.lqr).setLoop(true);
        }
        ah.M(SightCaptureUI.M(this.lqr));
        SightCaptureUI.S(this.lqr).setOneTimeVideoTextureUpdateCallback(new 1(this));
    }

    public final void wd() {
        SightCaptureUI.S(this.lqr).d(0.0d, true);
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
