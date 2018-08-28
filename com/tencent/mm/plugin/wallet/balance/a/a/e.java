package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.wallet_core.c.d;

public final class e extends a<bcp> implements d {
    public e(String str, String str2, int i, int i2) {
        b.a aVar = new b.a();
        aVar.dIG = new bco();
        aVar.dIH = new bcp();
        aVar.dIF = 1276;
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bco bco = (bco) KT.dID.dIL;
        bco.seK = str;
        bco.seL = i;
        bco.rtK = i2;
        bco.seM = str2;
        this.diG = KT;
    }
}
