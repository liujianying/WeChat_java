package com.tencent.mm.plugin.voip.model;

class o$8 implements Runnable {
    final /* synthetic */ o oMC;
    final /* synthetic */ int[] oMH;
    final /* synthetic */ boolean oMI;
    final /* synthetic */ int oMJ;

    o$8(o oVar, int[] iArr, boolean z, int i) {
        this.oMC = oVar;
        this.oMH = iArr;
        this.oMI = z;
        this.oMJ = i;
    }

    public final void run() {
        if (o.c(this.oMC) != null) {
            o.c(this.oMC).o(this.oMH);
        }
        if (o.j(this.oMC) != null) {
            o.j(this.oMC);
        }
    }
}
