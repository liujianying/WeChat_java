package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends j {
    private int myU = -1;
    public Orders pfb = null;

    public f(p pVar, Orders orders) {
        String str = null;
        int i = -1;
        this.pfb = orders;
        if (pVar.mpb != null) {
            this.myU = pVar.mpb.bVY;
            i = pVar.mpb.bVU;
        }
        List list = orders.ppf;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).bOe;
        }
        a(orders.bOd, str, this.myU, i, pVar.lMV, pVar.lMW);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        x.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bi.oW(pVar.eJn))});
        a(pVar.mpb, hashMap, hashMap2, r0);
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.eJn);
        hashMap.put("verify_code", pVar.pqM);
        hashMap.put("token", pVar.token);
        hashMap.put("favorcomposedid", pVar.plu);
        hashMap.put("default_favorcomposedid", pVar.plt);
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            x.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.pgm = true;
                this.pfb = Orders.a(jSONObject, this.pfb);
            } else {
                this.pgm = false;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.myU);
            if (this.myU == 39) {
                x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
                b.am(jSONObject);
                return;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.myU == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.myU == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    public int If() {
        if (this.myU == 11) {
            return 1684;
        }
        if (this.myU == 21) {
            return 1608;
        }
        return 474;
    }

    public final boolean bNv() {
        if (this.myU == 11 || this.myU == 21) {
            return true;
        }
        return false;
    }
}
