package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.model.p;

class FaceDetectView$5 implements Runnable {
    final /* synthetic */ p iPG = null;
    final /* synthetic */ FaceDetectView iTY;

    FaceDetectView$5(FaceDetectView faceDetectView) {
        this.iTY = faceDetectView;
    }

    public final void run() {
        this.iTY.iTG.aKF();
        if (this.iPG != null) {
            this.iPG.b(FaceDetectView.j(this.iTY).aKH());
        }
    }
}
