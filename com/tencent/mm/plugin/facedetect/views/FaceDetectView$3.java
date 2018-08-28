package com.tencent.mm.plugin.facedetect.views;

class FaceDetectView$3 implements Runnable {
    final /* synthetic */ FaceDetectView iTY;

    FaceDetectView$3(FaceDetectView faceDetectView) {
        this.iTY = faceDetectView;
    }

    public final void run() {
        if (FaceDetectView.d(this.iTY) != null && !FaceDetectView.a(this.iTY)) {
            FaceDetectView.d(this.iTY).M(0, "");
        }
    }
}
