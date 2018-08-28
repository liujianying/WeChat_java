package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bST;
    public boolean iMA;
    public String id;
    public String kQE;
    public String pGi;

    public b(String str, String str2, String str3) {
        this.id = str2;
        this.kQE = str3;
        this.bST = str;
        Map hashMap = new HashMap();
        hashMap.put("id", str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        F(hashMap);
    }

    public final int bOo() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.iMA = jSONObject.optBoolean("verified");
        this.pGi = jSONObject.optString("payu_reference");
    }
}
