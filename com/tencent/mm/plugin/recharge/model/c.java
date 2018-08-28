package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public String bTi;
    public b diG;
    private e diJ;
    public String ioy;

    public c(String str, String str2, String str3, String str4, String str5) {
        this.bTi = str2;
        this.ioy = str3;
        a aVar = new a();
        aVar.dIG = new xh();
        aVar.dIH = new xi();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        aVar.dIF = 1555;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        xh xhVar = (xh) this.diG.dID.dIL;
        xhVar.rDg = str;
        xhVar.rhu = str2;
        xhVar.lPm = str3;
        xhVar.rDh = str4;
        xhVar.rDi = str5;
        xhVar.rwj = com.tencent.mm.plugin.wallet_core.model.mall.c.bPK().Pe(str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
