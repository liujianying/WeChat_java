package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class a extends m {
    private b diG;
    private e diJ;

    public final int getType() {
        return 1554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bae bae = (bae) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + bae.iwS);
        }
        this.diJ.a(i, i2, bae.iwT, this);
    }
}
