package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$2 implements Runnable {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$2(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void run() {
        long VG = bi.VG();
        Runtime.getRuntime().gc();
        x.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
    }
}
