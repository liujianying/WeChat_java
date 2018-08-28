package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends i {
    public g(String str, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("resetpwd_token", str2);
        hashMap.put("passwd", str);
        F(hashMap);
        aC(hashMap2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", new Object[]{jSONObject.toString()});
    }

    public final int If() {
        return 1371;
    }

    public final int aBO() {
        return 1371;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
    }
}
