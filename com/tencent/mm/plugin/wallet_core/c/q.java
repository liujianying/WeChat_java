package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends i {
    public BindCardOrder piW;

    public q(p pVar) {
        this(pVar, -1);
    }

    public q(p pVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(pVar.mpb, hashMap, hashMap2);
        hashMap.put("flag", pVar.flag);
        if ("2".equals(pVar.flag)) {
            hashMap.put("passwd", pVar.eJn);
        }
        hashMap.put("verify_code", pVar.pqM);
        hashMap.put("token", pVar.token);
        if (!(pVar.mpb == null || bi.oW(pVar.mpb.bOd))) {
            hashMap.put("req_key", pVar.mpb.bOd);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        if (!bi.oW(pVar.lMV)) {
            hashMap.put("bank_type", pVar.lMV);
        }
        if (com.tencent.mm.wallet_core.c.p.cDb()) {
            hashMap2.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.p.cDd());
            hashMap2.put("bindcard_scene", com.tencent.mm.wallet_core.c.p.cDc());
        }
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("test", "test");
        this.piW = new BindCardOrder();
        this.piW.af(jSONObject);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int If() {
        return 472;
    }
}
