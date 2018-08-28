package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$26 implements OnClickListener {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$26(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.e(this.lqr) == 4) {
            SightCaptureUI.s(this.lqr);
        } else if (SightCaptureUI.e(this.lqr) == 3) {
            SightCaptureUI.t(this.lqr);
            SightCaptureUI.a(this.lqr, false);
        }
    }
}
