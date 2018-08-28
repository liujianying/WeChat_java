package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.network.q;

class c$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ int dJV;
    final /* synthetic */ byte[] dJW;
    final /* synthetic */ q dJe;
    final /* synthetic */ c jky;

    c$1(c cVar, int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.jky = cVar;
        this.dJV = i;
        this.bFq = i2;
        this.bFr = i3;
        this.dJG = str;
        this.dJe = qVar;
        this.dJW = bArr;
    }

    public final void run() {
        this.jky.b(this.dJV, this.bFq, this.bFr, this.dJG);
        if (this.jky.diJ != null) {
            this.jky.diJ.a(this.bFq, this.bFr, this.dJG, this.jky);
        }
    }
}
