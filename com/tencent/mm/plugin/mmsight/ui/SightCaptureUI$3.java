package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.w.a.a;

class SightCaptureUI$3 implements OnClickListener {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$3(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.v(this.lqr)) {
            this.lqr.finish();
            this.lqr.overridePendingTransition(-1, a.sight_slide_bottom_out);
        }
    }
}
