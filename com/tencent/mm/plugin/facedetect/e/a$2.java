package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a iSF;

    public a$2(a aVar) {
        this.iSF = aVar;
    }

    public final void run() {
        synchronized (a.a(this.iSF)) {
            if (a.n(this.iSF) == a.iSN) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                a.d(this.iSF);
            } else if (a.n(this.iSF) == a.iSP) {
                x.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
            } else {
                x.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                d.aJB().a(a.o(this.iSF));
                a.g(this.iSF).d(a.k(this.iSF), a.p(this.iSF), a.q(this.iSF));
                a.e(this.iSF, a.iSP);
            }
        }
    }
}
