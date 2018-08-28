package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.protocal.c.bdm;

public final class f extends a<bdm> {
    public f(String str, String str2, int i, int i2) {
        b.a aVar = new b.a();
        aVar.dIG = new bdl();
        aVar.dIH = new bdm();
        aVar.dIF = 1283;
        aVar.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bdl bdl = (bdl) KT.dID.dIL;
        bdl.sfu = str;
        bdl.myq = str2;
        bdl.seL = i;
        bdl.rtK = i2;
        this.diG = KT;
    }
}
