package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.a;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$9 implements a {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$9(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void onFinish() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
        FaceDetectUI.k(this.iRF);
        this.iRF.a(0, 0, "collect data ok", null);
    }
}
