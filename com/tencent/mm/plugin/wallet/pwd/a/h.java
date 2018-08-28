package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends i {
    public h(p pVar) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("verify_code", pVar.pqM);
        hashMap.put("token", pVar.token);
        a(pVar.mpb, hashMap, hashMap2);
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 11;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int If() {
        return 470;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdverify";
    }
}
