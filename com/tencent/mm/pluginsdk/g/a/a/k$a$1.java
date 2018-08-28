package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.g.a.bd;
import com.tencent.mm.pluginsdk.g.a.a.k.a;

class k$a$1 implements Runnable {
    final /* synthetic */ a qCF;
    final /* synthetic */ a qCG;

    k$a$1(a aVar, a aVar2) {
        this.qCG = aVar;
        this.qCF = aVar2;
    }

    public final void run() {
        bd bdVar = new bd();
        bdVar.bIG.bIC = this.qCF.bIC;
        bdVar.bIG.bID = this.qCF.bID;
        bdVar.bIG.bIJ = this.qCF.qBF;
        bdVar.bIG.bIH = 1;
        bdVar.bIG.bII = false;
        com.tencent.mm.sdk.b.a.sFg.m(bdVar);
    }
}
