package com.tencent.mm.plugin.facedetect.service;

import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectProcessService$2 implements Runnable {
    final /* synthetic */ FaceDetectProcessService iPD;
    final /* synthetic */ p iPG;

    FaceDetectProcessService$2(FaceDetectProcessService faceDetectProcessService, p pVar) {
        this.iPD = faceDetectProcessService;
        this.iPG = pVar;
    }

    public final void run() {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
        final FaceResult aJR = this.iPD.iPA.aJR();
        ah.A(new Runnable() {
            public final void run() {
                FaceDetectProcessService$2.this.iPG.b(aJR);
            }
        });
    }
}
