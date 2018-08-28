package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bST;
    public boolean pEV;
    public String pEx;
    public String pEy;

    public b(String str, String str2) {
        this.pEx = str;
        this.pEy = str2;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        F(hashMap);
    }

    public final int bOo() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.pEV = jSONObject.optBoolean("has_mobile");
        this.bST = jSONObject.optString("payu_reference");
    }
}
