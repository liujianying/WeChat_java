package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$5 implements c {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$5(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void pF(int i) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[]{Integer.valueOf(i)});
        if (i == 0) {
            FaceDetectUI.f(this.iRF);
        } else if (i == 1) {
            FaceDetectUI.g(this.iRF);
        } else if (i == 2) {
            FaceDetectUI.a(this.iRF, "camera permission not granted", this.iRF.getString(a$h.permission_camera_request_again_msg));
        }
    }
}
