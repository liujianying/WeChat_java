package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.awx;

public final class c extends a<awx> {
    public c(int i) {
        b.a aVar = new b.a();
        aVar.dIG = new aww();
        aVar.dIH = new awx();
        aVar.dIF = 1830;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        ((aww) KT.dID.dIL).rtK = i;
        this.diG = KT;
    }
}
