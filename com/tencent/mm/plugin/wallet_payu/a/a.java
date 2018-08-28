package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String bST;
    public boolean mSN;
    public String pET;
    public String pEU;

    public a(String str, String str2) {
        this.pET = str;
        this.bST = str2;
        Map hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", str2);
        F(hashMap);
    }

    public final int bOo() {
        return 4;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.mSN = jSONObject.optBoolean("verified");
        this.pEU = jSONObject.optString("payu_reference");
    }
}
