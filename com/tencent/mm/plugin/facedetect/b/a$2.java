package com.tencent.mm.plugin.facedetect.b;

class a$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ a iMi;

    a$2(a aVar, int i, int i2, String str) {
        this.iMi = aVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
    }

    public final void run() {
        if (this.iMi.iLX != null) {
            this.iMi.iLX.a(this.iMi.iMc, this.bFq, this.bFr, this.dJG);
        }
    }
}
