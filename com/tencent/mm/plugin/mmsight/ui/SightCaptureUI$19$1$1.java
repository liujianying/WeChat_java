package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.19.1;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$19$1$1 implements Runnable {
    final /* synthetic */ 1 lqz;

    SightCaptureUI$19$1$1(1 1) {
        this.lqz = 1;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
        if (SightCaptureUI.S(this.lqz.lqy.lqr) != null) {
            SightCaptureUI.S(this.lqz.lqy.lqr).setAlpha(1.0f);
            SightCaptureUI.g(this.lqz.lqy.lqr, 4);
            SightCaptureUI.F(this.lqz.lqy.lqr);
        }
    }
}
