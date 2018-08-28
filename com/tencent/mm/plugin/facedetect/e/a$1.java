package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ int iSA;
    final /* synthetic */ boolean iSB = false;
    final /* synthetic */ int iSC = 0;
    final /* synthetic */ int iSD;
    final /* synthetic */ int iSE;
    final /* synthetic */ a iSF;
    final /* synthetic */ int iSy;
    final /* synthetic */ int iSz;

    public a$1(a aVar, int i, int i2, int i3, int i4, int i5) {
        this.iSF = aVar;
        this.iSy = i;
        this.iSz = i2;
        this.iSA = i3;
        this.iSD = i4;
        this.iSE = i5;
    }

    public final void run() {
        if (this.iSy == 90 || this.iSy == f.CTRL_INDEX) {
            x.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
            a.a(this.iSF, this.iSz);
            a.b(this.iSF, this.iSA);
        } else {
            a.a(this.iSF, this.iSA);
            a.b(this.iSF, this.iSz);
        }
        synchronized (a.a(this.iSF)) {
            a.c(this.iSF, this.iSy);
            a.a(this.iSF, this.iSB);
            a.d(this.iSF, this.iSC);
        }
        a.b(this.iSF);
        a.c(this.iSF);
        a.d(this.iSF);
        ah.A(new 1(this));
    }
}
