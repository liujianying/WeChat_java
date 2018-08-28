package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$2 implements OnClickListener {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$2(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.u(this.lqr) != null) {
            SightCaptureUI.u(this.lqr).zY();
        }
        SightCaptureUI.q(this.lqr);
        SightCaptureUI.a(this.lqr, true);
    }
}
