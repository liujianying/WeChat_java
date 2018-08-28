package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect$b;

class FaceDetectUI$3 implements FaceScanRect$b {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$3(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void aKx() {
        FaceDetectView c = FaceDetectUI.c(this.iRF);
        RectF rectF = new RectF((float) FaceDetectUI.b(this.iRF).getLeft(), (float) FaceDetectUI.b(this.iRF).getTop(), (float) FaceDetectUI.b(this.iRF).getRight(), (float) FaceDetectUI.b(this.iRF).getBottom());
        FaceDetectDecorView faceDetectDecorView = c.iTH;
        faceDetectDecorView.iTC = true;
        faceDetectDecorView.iTD = true;
        faceDetectDecorView.iTE = rectF;
        faceDetectDecorView.invalidate();
    }
}
