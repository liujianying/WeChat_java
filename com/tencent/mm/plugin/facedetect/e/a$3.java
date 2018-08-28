package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ a iSF;

    a$3(a aVar) {
        this.iSF = aVar;
    }

    public final void run() {
        synchronized (a.a(this.iSF)) {
            if (a.n(this.iSF) == a.iSN) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                a.d(this.iSF);
                return;
            }
            x.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
            a.g(this.iSF).cancel();
            a.d(this.iSF);
            d.aJB().b(a.o(this.iSF));
            a.e(this.iSF, a.iSS);
            a.m(this.iSF).release();
        }
    }
}
