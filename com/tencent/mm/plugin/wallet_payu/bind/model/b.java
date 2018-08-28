package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bST;
    public String pEe;

    public b(String str, String str2) {
        this.pEe = str;
        this.bST = str2;
        Map hashMap = new HashMap();
        hashMap.put("bind_serial", str);
        hashMap.put("payu_reference", str2);
        F(hashMap);
    }

    public final int bOo() {
        return 6;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
