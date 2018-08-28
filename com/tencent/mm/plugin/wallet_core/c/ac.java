package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends i {
    public String pjE;
    public String pjt;

    public ac(p pVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", pVar.pqM);
        hashMap.put("token", pVar.token);
        hashMap.put("passwd", pVar.eJn);
        hashMap.put("relation_key", str);
        F(hashMap);
    }

    public final int aBO() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.pjt = jSONObject.optString("token_type");
            this.pjE = jSONObject.optString("usertoken");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int If() {
        return 1604;
    }
}
