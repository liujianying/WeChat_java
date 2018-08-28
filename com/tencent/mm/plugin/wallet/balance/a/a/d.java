package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.fe;

public final class d extends a<bbl> {
    public d(int i, fe feVar, int i2) {
        b.a aVar = new b.a();
        aVar.dIG = new bbk();
        aVar.dIH = new bbl();
        aVar.dIF = 1324;
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bbk bbk = (bbk) KT.dID.dIL;
        bbk.sdC = i;
        if (feVar != null) {
            bbk.sdD = 1;
            bbk.sdE = feVar;
        } else {
            bbk.sdD = 0;
            bbk.sdE = null;
        }
        bbk.rtK = i2;
        this.diG = KT;
    }
}
