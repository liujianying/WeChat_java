package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends m {
    private b diG;
    private com.tencent.mm.ab.e diJ;

    public e(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new kq();
        aVar.dIH = new kr();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.dIF = 410;
        aVar.dII = 198;
        aVar.dIJ = 1000000198;
        this.diG = aVar.KT();
        kq kqVar = (kq) this.diG.dID.dIL;
        kqVar.rmP = str;
        kqVar.reo = str2;
        kqVar.rmQ = i.bOL();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 410;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
