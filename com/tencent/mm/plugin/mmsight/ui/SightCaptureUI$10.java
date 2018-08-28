package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

class SightCaptureUI$10 implements Runnable {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$10(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void run() {
        String Ho = d.Ho(SightCaptureUI.n(this.lqr).getFilePath());
        if (!bi.oW(Ho)) {
            ah.A(new 1(this, ((Ho + "\n" + String.format("FPS: %s", new Object[]{Float.valueOf(SightCaptureUI.n(this.lqr).bek())})) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(d.Hq("TIME_RECODER_2_PLAY"))})) + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.zm(), m.zk()})));
        }
    }
}
