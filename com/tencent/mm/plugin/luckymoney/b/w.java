package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class w extends ab {
    long bJC;
    public f kQP;
    public String kRb;
    String talker;

    public w(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, "");
    }

    public w(String str, int i, String str2, long j, String str3, String str4) {
        this.kQP = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        F(hashMap);
    }

    public w(String str, int i, int i2, String str2, String str3, String str4) {
        this.kQP = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        F(hashMap);
    }

    public final int getType() {
        return 1585;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.kQP = m.M(jSONObject);
            this.kRb = jSONObject.optString("processContent");
        } catch (JSONException e) {
            x.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }
}
