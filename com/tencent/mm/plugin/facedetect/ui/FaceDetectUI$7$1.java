package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.7;

class FaceDetectUI$7$1 implements Runnable {
    final /* synthetic */ Bitmap iRH;
    final /* synthetic */ 7 iRI;

    FaceDetectUI$7$1(7 7, Bitmap bitmap) {
        this.iRI = 7;
        this.iRH = bitmap;
    }

    public final void run() {
        FaceDetectUI.j(this.iRI.iRF).z(this.iRH);
    }
}
