package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String bST;
    public String id;
    public String pGj;

    public c() {
        this("");
    }

    public c(String str) {
        this.bST = str;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", bi.aG(str, ""));
        F(hashMap);
    }

    public final int bOo() {
        return 23;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.pGj = jSONObject.optString("description");
    }
}
