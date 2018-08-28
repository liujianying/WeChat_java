package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends i implements d {
    public String appId;
    public String bKk;
    public String bOd;
    public int bVU;
    public String fFG;
    public String pCO;
    public int scene;
    public String uYk;

    public k(String str, int i, int i2, int i3, int i4, String str2) {
        this.scene = i;
        this.bVU = i3;
        Map hashMap = new HashMap();
        hashMap.put("url", URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        x.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", Integer.valueOf(i4), str2);
        if (i4 < 0) {
            x.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", Integer.valueOf(i4), str2);
            hashMap.put("source_type", "0");
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        F(hashMap);
    }

    public final int aBO() {
        return 127;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        x.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", jSONObject.toString());
        this.bOd = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.pCO = jSONObject.optString("appsource");
        this.bKk = jSONObject.optString("productid");
        this.uYk = jSONObject.optString("retcode");
        this.fFG = jSONObject.optString("retmsg");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    public final int If() {
        return 1694;
    }
}
