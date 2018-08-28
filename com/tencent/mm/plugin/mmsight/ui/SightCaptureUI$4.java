package com.tencent.mm.plugin.mmsight.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;

class SightCaptureUI$4 implements a {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$4(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void N(float f, float f2) {
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.e(this.lqr) != 3 && SightCaptureUI.e(this.lqr) != 4 && SightCaptureUI.w(this.lqr) != null) {
            e h = SightCaptureUI.h(this.lqr);
            int width = SightCaptureUI.w(this.lqr).getWidth();
            int height = SightCaptureUI.w(this.lqr).getHeight();
            if (!d.fS(14)) {
                h.lga.removeMessages(4354);
                h.lga.lgk = f;
                h.lga.kuY = f2;
                h.lga.lgl = width;
                h.lga.lgm = height;
                h.lga.sendMessageDelayed(h.lga.obtainMessage(4354, h.ddt), 400);
            }
            SightCaptureUI sightCaptureUI = this.lqr;
            if (sightCaptureUI.lpJ != null) {
                LayoutParams layoutParams = (LayoutParams) sightCaptureUI.lpJ.getLayoutParams();
                layoutParams.leftMargin = ((int) f) - (sightCaptureUI.lpJ.mWidth / 2);
                layoutParams.topMargin = ((int) f2) - (sightCaptureUI.lpJ.mHeight / 2);
                sightCaptureUI.lpJ.setLayoutParams(layoutParams);
                CameraFrontSightView cameraFrontSightView = sightCaptureUI.lpJ;
                cameraFrontSightView.setVisibility(0);
                cameraFrontSightView.lnT = true;
                cameraFrontSightView.lnU = false;
                cameraFrontSightView.lnV = false;
                cameraFrontSightView.lnW = false;
                cameraFrontSightView.lnX = System.currentTimeMillis();
                cameraFrontSightView.invalidate();
            }
        }
    }

    public final void bfc() {
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.x(this.lqr) > 1) {
            SightCaptureUI.h(this.lqr).lga.removeMessages(4354);
            SightCaptureUI.r(this.lqr);
        }
    }

    public final void aab() {
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.h(this.lqr) != null) {
            SightCaptureUI.h(this.lqr).b(true, false, 1);
        }
    }

    public final void aac() {
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.h(this.lqr) != null) {
            SightCaptureUI.h(this.lqr).b(false, false, 1);
        }
    }
}
