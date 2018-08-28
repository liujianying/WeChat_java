package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.1.1;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1$1 implements Runnable {
    final /* synthetic */ long iSH;
    final /* synthetic */ 1 iSI;

    a$1$1$1(1 1, long j) {
        this.iSI = 1;
        this.iSH = j;
    }

    public final void run() {
        synchronized (a.a(this.iSI.iSG.iSF)) {
            x.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[]{Long.valueOf(bi.bI(this.iSH))});
            long VG = bi.VG();
            a.a(this.iSI.iSG.iSF, a.e(this.iSI.iSG.iSF).ZO());
            a.g(this.iSI.iSG.iSF).setFilePath(a.f(this.iSI.iSG.iSF));
            a.g(this.iSI.iSG.iSF).Hr(a.h(this.iSI.iSG.iSF));
            a.g(this.iSI.iSG.iSF).bes();
            a.g(this.iSI.iSG.iSF).p(a.i(this.iSI.iSG.iSF), a.j(this.iSI.iSG.iSF), this.iSI.iSG.iSD, this.iSI.iSG.iSE);
            a.g(this.iSI.iSG.iSF).sQ(a.k(this.iSI.iSG.iSF));
            a.g(this.iSI.iSG.iSF).a(a.l(this.iSI.iSG.iSF));
            a.e(this.iSI.iSG.iSF, a.iSO);
            x.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
        }
    }
}
