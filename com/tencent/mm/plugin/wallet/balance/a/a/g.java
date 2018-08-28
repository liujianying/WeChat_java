package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;

public final class g extends a<bdo> {
    private b eAN;
    private bdn oYF = null;

    public g() {
        b.a aVar = new b.a();
        aVar.dIG = new bdn();
        aVar.dIH = new bdo();
        aVar.dIF = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.oYF = (bdn) this.eAN.dID.dIL;
        this.oYF.time_stamp = (int) System.currentTimeMillis();
        this.diG = aVar.KT();
    }
}
