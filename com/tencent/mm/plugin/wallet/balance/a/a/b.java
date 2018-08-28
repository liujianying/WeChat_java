package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.protocal.c.awu;
import com.tencent.mm.protocal.c.awv;

public final class b extends a<awv> {
    public b(int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new awu();
        aVar.dIH = new awv();
        aVar.dIF = 2585;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        aVar.dII = 0;
        aVar.dIJ = 0;
        com.tencent.mm.ab.b KT = aVar.KT();
        ((awu) KT.dID.dIL).rtK = i;
        this.diG = KT;
    }
}
