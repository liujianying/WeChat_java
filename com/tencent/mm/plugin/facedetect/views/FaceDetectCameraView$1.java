package com.tencent.mm.plugin.facedetect.views;

class FaceDetectCameraView$1 implements Runnable {
    final /* synthetic */ FaceDetectCameraView iTq;

    FaceDetectCameraView$1(FaceDetectCameraView faceDetectCameraView) {
        this.iTq = faceDetectCameraView;
    }

    public final void run() {
        this.iTq.a(FaceDetectCameraView.b(this.iTq), FaceDetectCameraView.c(this.iTq));
        FaceDetectCameraView.a(this.iTq, false);
    }
}
