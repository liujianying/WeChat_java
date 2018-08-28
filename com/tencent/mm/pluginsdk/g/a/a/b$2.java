package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.g.a.be;
import com.tencent.mm.sdk.b.a;

class b$2 implements Runnable {
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;
    final /* synthetic */ b qBO;
    final /* synthetic */ int qBP;
    final /* synthetic */ boolean qBQ;

    b$2(b bVar, int i, int i2, int i3, boolean z) {
        this.qBO = bVar;
        this.qBP = i;
        this.kPA = i2;
        this.kPB = i3;
        this.qBQ = z;
    }

    public final void run() {
        be beVar = new be();
        beVar.bIK.bIH = this.qBP;
        beVar.bIK.bIC = this.kPA;
        beVar.bIK.bID = this.kPB;
        beVar.bIK.bIJ = this.qBQ;
        a.sFg.m(beVar);
    }
}
