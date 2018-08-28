package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.ui.a.b;

class FaceDetectPrepareUI$4 implements Runnable {
    final /* synthetic */ b iQq;
    final /* synthetic */ FaceDetectPrepareUI iRf;
    final /* synthetic */ boolean iRg = true;

    FaceDetectPrepareUI$4(FaceDetectPrepareUI faceDetectPrepareUI, b bVar) {
        this.iRf = faceDetectPrepareUI;
        this.iQq = bVar;
    }

    public final void run() {
        this.iRf.a(true, this.iRg, this.iQq);
    }
}
