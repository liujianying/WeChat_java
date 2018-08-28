package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends i implements d {
    public e(p pVar) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.eJn);
        hashMap.put("rpasswd", pVar.eJn);
        hashMap.put("verify_code", pVar.pqM);
        hashMap.put("token", pVar.token);
        a(pVar.mpb, hashMap, hashMap2);
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int If() {
        return 478;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
