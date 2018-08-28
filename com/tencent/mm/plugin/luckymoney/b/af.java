package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bi;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends ab {
    public String kLZ;
    public String kRq;
    public String kRr;

    public af(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i));
        hashMap.put("wishing", URLEncoder.encode(bi.oV(str)));
        hashMap.put("sendUserName", str4);
        if (!bi.oW(str3)) {
            hashMap.put("username", str3);
        }
        if (!bi.oW(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!bi.oW(str5)) {
            hashMap.put("nickName", URLEncoder.encode(bi.oV(str5)));
        }
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", String.valueOf(i3));
        F(hashMap);
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    public final int getType() {
        return 1643;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kLZ = jSONObject.optString("sendId");
        this.kRq = jSONObject.optString("reqkey");
        this.kRr = jSONObject.optString("sendMsgXml");
    }
}
