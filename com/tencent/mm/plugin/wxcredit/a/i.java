package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class i extends m {
    private b diG;
    private e diJ;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bgf();
        aVar.dIH = new bgg();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        aVar.dIF = Downloads.DOWNLOAD_ERR_INTERRUPTED;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bgf bgf = (bgf) this.diG.dID.dIL;
        bgf.sho = str;
        bgf.shn = bi.getInt(str2, 0);
        bgf.rmQ = com.tencent.mm.plugin.wallet_core.model.i.bOL();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return Downloads.DOWNLOAD_ERR_INTERRUPTED;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
