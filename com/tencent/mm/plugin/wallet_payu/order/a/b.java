package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.protocal.c.bag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class b extends m {
    private com.tencent.mm.ab.b diG;
    private e diJ;

    public b(String str) {
        a aVar = new a();
        aVar.dIG = new baf();
        aVar.dIH = new bag();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        aVar.dIF = 1544;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        baf baf = (baf) this.diG.dID.dIL;
        if (!bi.oW(str)) {
            baf.lOE = str;
        }
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1544;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
