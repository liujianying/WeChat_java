package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String bST;
    public String pEA;
    public String pEB;
    public String pEx;
    public String pEy;
    public String pEz;
    public String pin;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.pEx = str;
        this.pEy = str2;
        this.pin = str3;
        this.pEA = str4;
        this.pEz = str4;
        this.pEB = str6;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("secret_question_id", str4);
        hashMap.put("secret_question_answer", str5);
        hashMap.put("payu_reference", str6);
        F(hashMap);
    }

    public final int bOo() {
        return 5;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.bST = jSONObject.optString("payu_reference");
    }
}
