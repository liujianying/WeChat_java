package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.brq;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.m;

public final class g extends m implements d {
    private b diG;
    private e diJ;
    public String mAppId;
    public PayInfo mpb;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.moy, mallRechargeProduct.bKk, str);
    }

    public g(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.dIG = new brq();
        aVar.dIH = new brr();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.dIF = 498;
        aVar.dII = 230;
        aVar.dIJ = 1000000230;
        this.diG = aVar.KT();
        brq brq = (brq) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[]{str4});
        this.mAppId = str;
        brq.rDh = str;
        brq.rDg = str2;
        brq.rIL = str3;
        brq.rDi = str4;
        brq.rwj = c.bPK().Pe(str2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        this.mpb = new PayInfo();
        brr brr = (brr) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + brr.reo);
            this.mpb.appId = this.mAppId;
            this.mpb.pCO = brr.rEg;
            this.mpb.bOd = brr.reo;
        }
        if (i2 == 0) {
            i2 = brr.rDj;
        }
        if (bi.oW(str)) {
            str = brr.rDk;
        }
        this.mpb.qUK = String.valueOf(i2);
        this.mpb.Yy = str != null ? str : "";
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 498;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
