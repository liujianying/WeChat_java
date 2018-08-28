package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.5;

class FaceDetectPrepareUI$5$1 implements Runnable {
    final /* synthetic */ Bitmap iRh;
    final /* synthetic */ 5 iRi;

    FaceDetectPrepareUI$5$1(5 5, Bitmap bitmap) {
        this.iRi = 5;
        this.iRh = bitmap;
    }

    public final void run() {
        FaceDetectPrepareUI.f(this.iRi.iRf).z(this.iRh);
    }
}
