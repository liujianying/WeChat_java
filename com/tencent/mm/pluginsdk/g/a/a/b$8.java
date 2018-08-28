package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.a;

class b$8 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;
    final /* synthetic */ b qBO;
    final /* synthetic */ int qBY;
    final /* synthetic */ boolean qBZ;

    b$8(b bVar, int i, int i2, String str, int i3, boolean z) {
        this.qBO = bVar;
        this.kPA = i;
        this.kPB = i2;
        this.ewx = str;
        this.qBY = i3;
        this.qBZ = z;
    }

    public final void run() {
        bc bcVar = new bc();
        bcVar.bIB.bIC = this.kPA;
        bcVar.bIB.bID = this.kPB;
        bcVar.bIB.filePath = this.ewx;
        bcVar.bIB.bIE = this.qBY;
        bcVar.bIB.bIF = this.qBZ;
        a.sFg.m(bcVar);
    }
}
