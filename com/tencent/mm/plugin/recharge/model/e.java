package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public ArrayList<MallRechargeProduct> moL = null;
    public String moM;
    public String moN;
    public String moO;
    public String moP;
    public String moy;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new agc();
        aVar.dIH = new agd();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.dIF = 496;
        aVar.dII = 228;
        aVar.dIJ = 1000000228;
        this.diG = aVar.KT();
        agc agc = (agc) this.diG.dID.dIL;
        this.moy = str;
        agc.rDg = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            agd agd = (agd) ((b) qVar).dIE.dIL;
            String str2 = agd.rIN;
            x.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + str2);
            if (!bi.oW(str2)) {
                try {
                    this.moL = b.a(this.moy, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!bi.oW(agd.rJR)) {
                try {
                    JSONObject jSONObject = new JSONObject(agd.rJR);
                    this.moM = jSONObject.optString("balance_link");
                    this.moO = jSONObject.optString("recharge_link");
                    this.moN = jSONObject.optString("balance_wording");
                    this.moP = jSONObject.optString("recharge_wording");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 496;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
