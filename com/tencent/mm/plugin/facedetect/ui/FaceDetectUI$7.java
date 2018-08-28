package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ah;

class FaceDetectUI$7 implements Runnable {
    final /* synthetic */ FaceDetectUI iRF;
    final /* synthetic */ Bitmap iRG;

    FaceDetectUI$7(FaceDetectUI faceDetectUI, Bitmap bitmap) {
        this.iRF = faceDetectUI;
        this.iRG = bitmap;
    }

    public final void run() {
        ah.A(new 1(this, o.o(FaceDetectUI.i(this.iRF), this.iRG)));
    }
}
