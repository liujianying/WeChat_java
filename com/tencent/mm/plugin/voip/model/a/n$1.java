package com.tencent.mm.plugin.voip.model.a;

class n$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ n oOe;

    n$1(n nVar, int i, int i2, String str) {
        this.oOe = nVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
    }

    public final void run() {
        if (this.oOe.diJ != null) {
            this.oOe.diJ.a(this.bFq, this.bFr, this.dJG, this.oOe);
        }
    }
}
