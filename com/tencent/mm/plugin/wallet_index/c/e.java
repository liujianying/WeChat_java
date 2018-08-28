package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.m;

public final class e extends m implements d {
    public b diG;
    private com.tencent.mm.ab.e diJ;

    public e(PayReq payReq, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.dIG = new aza();
        aVar.dIH = new azb();
        aVar.uri = "/cgi-bin/mmpay-bin/payauthapp";
        aVar.dIF = 397;
        aVar.dII = 188;
        aVar.dIJ = 1000000188;
        this.diG = aVar.KT();
        aza aza = (aza) this.diG.dID.dIL;
        aza.jQb = payReq.appId;
        aza.sbN = payReq.partnerId;
        aza.rEf = payReq.prepayId;
        aza.rsw = payReq.nonceStr;
        aza.sbO = payReq.timeStamp;
        aza.rsx = payReq.packageValue;
        aza.rsy = payReq.sign;
        aza.rsz = payReq.signType;
        aza.sbP = str;
        aza.jPg = str2;
        aza.jSv = str3;
        aza.rmQ = i.bOL();
        aza.sbR = str4;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 397;
    }
}
