package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class c extends m {
    private b diG;
    private e diJ;
    public azz pEY = null;

    public c(String str) {
        a aVar = new a();
        aVar.dIG = new baj();
        aVar.dIH = new bak();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.dIF = 1520;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        baj baj = (baj) this.diG.dID.dIL;
        if (!bi.oW(str)) {
            baj.lOE = str;
        }
    }

    public final int getType() {
        return 1520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.diJ.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            bak bak = (bak) ((b) qVar).dIE.dIL;
            this.pEY = bak.scQ;
            if (bak.scQ != null) {
                x.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + bak.scQ.lOE);
            } else {
                x.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
            }
        }
    }
}
