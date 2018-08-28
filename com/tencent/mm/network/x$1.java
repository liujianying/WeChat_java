package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;

class x$1 implements Runnable {
    final /* synthetic */ boolean esZ;
    final /* synthetic */ long eta;
    final /* synthetic */ String etb;
    final /* synthetic */ boolean etc;
    final /* synthetic */ x etd;

    x$1(x xVar, boolean z, long j, String str, boolean z2) {
        this.etd = xVar;
        this.esZ = z;
        this.eta = j;
        this.etb = str;
        this.etc = z2;
    }

    public final void run() {
        if (this.esZ) {
            SmcLogic.writeImportKvData(this.eta, this.etb, this.etc);
        } else {
            SmcLogic.writeKvData(this.eta, this.etb, this.etc);
        }
    }

    public final String toString() {
        return super.toString() + "|reportKV";
    }
}
