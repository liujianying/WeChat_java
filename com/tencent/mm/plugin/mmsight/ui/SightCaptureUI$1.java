package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$1 implements Runnable {
    final /* synthetic */ long jEc;
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$1(SightCaptureUI sightCaptureUI, long j) {
        this.lqr = sightCaptureUI;
        this.jEc = j;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[]{Long.valueOf(bi.bI(this.jEc))});
        j.c(SightCaptureUI.a(this.lqr).lem);
        SightCaptureUI.b(this.lqr);
    }
}
