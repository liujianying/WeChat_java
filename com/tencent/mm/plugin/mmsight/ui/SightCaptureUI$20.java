package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$20 implements OnClickListener {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$20(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.e(this.lqr) == 3) {
            SightCaptureUI.f(this.lqr);
        } else if (SightCaptureUI.e(this.lqr) == 4) {
            SightCaptureUI.g(this.lqr);
        }
    }
}
