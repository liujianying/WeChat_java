package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONObject;

public final class d extends l implements k {
    public b diG;
    private e diJ;
    public String eNQ;
    public int moF;
    public MallRechargeProduct moI = null;
    public List<MallRechargeProduct> moJ = null;
    public String moK;
    public String moy;
    public String moz = null;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        this.moy = str;
        this.moF = i;
        this.eNQ = str5;
        this.moK = str2;
        a aVar = new a();
        aVar.dIG = new aev();
        aVar.dIH = new aew();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.dIF = 497;
        aVar.dII = 229;
        aVar.dIJ = 1000000229;
        this.diG = aVar.KT();
        aev aev = (aev) this.diG.dID.dIL;
        aev.rDg = str;
        aev.rDh = str3;
        aev.rIL = str2;
        aev.rDi = str4;
        aev.rwj = c.bPK().Pe(str);
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        aew aew = (aew) ((b) qVar).dIE.dIL;
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + aew.rDl);
        String str2 = aew.rDl;
        this.moz = "";
        if (!bi.oW(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.moz += " ";
                        } else {
                            obj = null;
                        }
                        this.moz += split3[1];
                    }
                }
            }
        }
        if (!bi.oW(aew.rIN)) {
            try {
                this.moJ = b.a(this.moy, new JSONObject(aew.rIN).optJSONArray("product_info"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = aew.rIM;
            x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + str2);
            if (!bi.oW(str2)) {
                try {
                    this.moI = b.d(this.moy, new JSONObject(str2));
                    this.moI.moz = this.moz;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(aew.rDj), aew.rDk, Integer.valueOf(aew.rDm), aew.rDn}));
        if (i3 == 0) {
            if (aew.rDm != 0) {
                i3 = aew.rDm;
            } else {
                i3 = aew.rDj;
            }
        }
        if (bi.oW(str)) {
            if (bi.oW(aew.rDn)) {
                str = aew.rDk;
            } else {
                str = aew.rDn;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 497;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
