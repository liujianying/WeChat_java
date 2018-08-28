package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c$4$1 implements Runnable {
    final /* synthetic */ 4 iTA;

    FaceDetectCameraView$c$4$1(4 4) {
        this.iTA = 4;
    }

    public final void run() {
        x.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
        long VG = bi.VG();
        long p = VG - FaceDetectCameraView.p(this.iTA.iTy.iTq);
        if (FaceDetectCameraView.p(this.iTA.iTy.iTq) >= 0) {
            x.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[]{Long.valueOf(p)});
        }
        if (FaceDetectCameraView.p(this.iTA.iTy.iTq) < 0 || p > FaceDetectCameraView.c(this.iTA.iTy.iTq)) {
            FaceDetectCameraView.a(this.iTA.iTy.iTq, VG);
            FaceDetectCameraView.b(this.iTA.iTy.iTq, FaceDetectCameraView.o(this.iTA.iTy.iTq));
        }
    }
}
