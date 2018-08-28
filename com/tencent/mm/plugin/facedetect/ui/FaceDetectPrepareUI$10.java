package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$10 implements Runnable {
    final /* synthetic */ FaceDetectPrepareUI iRf;
    final /* synthetic */ String iRk;

    FaceDetectPrepareUI$10(FaceDetectPrepareUI faceDetectPrepareUI, String str) {
        this.iRf = faceDetectPrepareUI;
        this.iRk = str;
    }

    public final void run() {
        try {
            FaceDetectPrepareUI.c(this.iRf).AS(this.iRk);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
        }
    }
}
