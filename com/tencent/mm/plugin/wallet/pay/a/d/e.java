package com.tencent.mm.plugin.wallet.pay.a.d;

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

public class e extends j {
    private int myU = -1;
    public Orders pfb = null;
    protected p pfq;

    public e(p pVar, Orders orders) {
        String str = null;
        this.pfb = orders;
        this.pfq = pVar;
        List list = orders.ppf;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).bOe;
        }
        if (pVar.mpb == null) {
            x.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            return;
        }
        this.myU = pVar.mpb.bVY;
        a(orders.bOd, str, pVar.mpb.bVY, pVar.mpb.bVU, pVar.lMV, pVar.lMW);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.eJn);
        x.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bi.oW(pVar.eJn))});
        a(pVar.mpb, hashMap, hashMap2, r0);
        hashMap.put("verify_type", pVar.bVC);
        if (pVar.bVC == 0) {
            hashMap.put("verify_code", pVar.pqM);
        } else {
            hashMap.put("cre_tail", pVar.pqO);
            hashMap.put("cre_type", pVar.pqP);
        }
        hashMap.put("token", pVar.token);
        hashMap.put("bank_type", pVar.lMV);
        hashMap.put("bind_serial", pVar.lMW);
        hashMap.put("arrive_type", pVar.plq);
        hashMap.put("default_favorcomposedid", pVar.plt);
        hashMap.put("favorcomposedid", pVar.plu);
        Q(hashMap);
        if (com.tencent.mm.wallet_core.c.p.cDb()) {
            hashMap2.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.p.cDd());
            hashMap2.put("bindcard_scene", com.tencent.mm.wallet_core.c.p.cDc());
        }
        F(hashMap);
        aC(hashMap2);
    }

    protected void Q(Map<String, String> map) {
    }

    public int aBO() {
        return 1;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            x.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.pgm = true;
                this.pfb = Orders.a(jSONObject, this.pfb);
            } else {
                this.pgm = false;
            }
            x.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.myU);
            if (this.myU == 39) {
                x.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
                b.am(jSONObject);
                return;
            }
            x.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.myU == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.myU == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    public int If() {
        if (this.myU == 11) {
            return 1607;
        }
        if (this.myU == 21) {
            return 1606;
        }
        return 462;
    }

    public final boolean bNv() {
        if (this.myU == 11 || this.myU == 21) {
            return true;
        }
        return false;
    }
}
