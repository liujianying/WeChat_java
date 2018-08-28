package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class a extends m {
    public b diG;
    private e diJ;

    public a(int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bac();
        aVar.dIH = new bad();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        aVar.dIF = 1519;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bac bac = (bac) this.diG.dID.dIL;
        bac.jSb = 10;
        bac.rjC = i;
        x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:" + i);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.diJ.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((bad) ((b) qVar).dIE.dIL).scN);
        }
    }

    public final int bRl() {
        return ((bad) this.diG.dIE.dIL).scN;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
