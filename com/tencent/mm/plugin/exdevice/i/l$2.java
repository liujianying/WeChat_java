package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.service.p;

class l$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ l izN;
    final /* synthetic */ long izO;
    final /* synthetic */ p izP;

    l$2(l lVar, long j, int i, int i2, String str, p pVar) {
        this.izN = lVar;
        this.izO = j;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.izP = pVar;
    }

    public final void run() {
        l.c(this.izN).a(this.izO, this.bFq, this.bFr, this.dJG, this.izP);
    }

    public final String toString() {
        return super.toString() + "|onTaskEnd";
    }
}
