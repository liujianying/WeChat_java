package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String pDZ;
    public PayUBankcardElement pEb;

    public NetScenePayUElementQuery(String str) {
        this.pDZ = str;
        Map hashMap = new HashMap();
        hashMap.put("card_number", str);
        F(hashMap);
    }

    public final int bOo() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pEb = new PayUBankcardElement();
        this.pEb.pEc = jSONObject.optString("bin");
        this.pEb.lNT = jSONObject.optString("bank_name");
        this.pEb.pEd = jSONObject.optString("issuer_type");
        this.pEb.cardType = jSONObject.optString("card_type");
        this.pEb.bST = jSONObject.optString("payu_reference");
    }
}
