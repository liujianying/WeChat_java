package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.protocal.c.pk;

public final class a extends com.tencent.mm.ab.a<pk> {
    public a(String str, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new pj();
        aVar.dIH = new pk();
        aVar.dIF = 1386;
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        pj pjVar = (pj) KT.dID.dIL;
        pjVar.rtJ = str;
        pjVar.rtK = i;
        this.diG = KT;
    }
}
