package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.14;
import com.tencent.mm.plugin.w.a.f;

class SightCaptureUI$14$2 implements Runnable {
    final /* synthetic */ 14 lqx;

    SightCaptureUI$14$2(14 14) {
        this.lqx = 14;
    }

    public final void run() {
        Toast.makeText(this.lqx.lqr, f.mmsight_clip_failed, 1).show();
        this.lqx.lqr.DO(8);
        SightCaptureUI.G(this.lqx.lqr).setVisibility(0);
        SightCaptureUI.Q(this.lqx.lqr).setVisibility(0);
        SightCaptureUI.R(this.lqx.lqr).setVisibility(0);
    }
}
