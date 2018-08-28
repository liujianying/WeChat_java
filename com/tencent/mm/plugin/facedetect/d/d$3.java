package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ d iPx;

    d$3(d dVar) {
        this.iPx = dVar;
    }

    public final void run() {
        synchronized (this.iPx.iPq) {
            if (this.iPx.iPd >= this.iPx.iPc.length - 1) {
                x.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                this.iPx.iOL = true;
                f fVar = f.iNu;
                byte[] e = FileOp.e(this.iPx.iPb.iOC, -1, -1);
                g gVar = fVar.iNv.iPA;
                if (gVar.iNy == null) {
                    x.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                } else {
                    gVar.iNy.engineSetVoiceData(e);
                }
            } else {
                x.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                d dVar = this.iPx;
                dVar.iPd++;
                this.iPx.iPe = -1;
                this.iPx.eK(true);
                this.iPx.aKk();
            }
        }
    }
}
