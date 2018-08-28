package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends i {
    public String pju;
    public int pjv;
    public String pjw;
    public String pjx;

    public s(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        hashMap.put("use_touch", "1");
        F(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str2);
        aC(hashMap);
    }

    public s(String str, String str2, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        F(hashMap);
        aC(new HashMap());
    }

    public s(String str, String str2, char c) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        F(hashMap);
        aC(new HashMap());
    }

    public final int aBO() {
        return 100;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.pju = jSONObject.optString("usertoken");
        this.pjv = jSONObject.optInt("is_free_sms");
        this.pjw = jSONObject.optString("mobile_no");
        this.pjx = jSONObject.optString("relation_key");
    }

    public final boolean bOk() {
        return this.pjv == 0;
    }

    public final int If() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
