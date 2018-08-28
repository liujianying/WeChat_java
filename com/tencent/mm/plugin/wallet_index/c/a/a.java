package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class a extends m {
    private b diG;
    private e diJ;
    public String jumpUrl;
    public String pCO;
    public String pCZ;
    public String prepayId;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new azn();
        aVar.dIH = new azo();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        this.diG = aVar.KT();
        azn azn = (azn) this.diG.dID.dIL;
        azn.jQb = str;
        azn.rsx = str4;
        azn.rsw = str2;
        azn.rsy = str5;
        azn.rsz = str6;
        azn.rhq = str3;
        azn.rrC = str7;
        azn.rEe = str8;
        azn.qZe = i;
        x.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        azo azo = (azo) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(azo.iwS), azo.iwT);
            str = azo.iwT;
            i2 = azo.iwS;
            this.jumpUrl = azo.jOU;
            this.prepayId = azo.rEf;
            this.pCO = azo.rEg;
            this.pCZ = azo.scf;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (bi.oW(str)) {
            str = ad.getContext().getString(i.wallet_data_err);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
