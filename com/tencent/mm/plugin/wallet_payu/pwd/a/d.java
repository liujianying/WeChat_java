package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String bST;
    public String pFN;
    public String pFO;

    public d(String str, String str2) {
        this.pFN = str;
        this.pFO = str2;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        F(hashMap);
    }

    public final int bOo() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.bST = jSONObject.optString("payu_reference");
    }
}
