package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends ab {
    public aa(String str, String str2, int i, int i2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i));
        hashMap.put("receiveId", str2);
        hashMap.put("ver", str3);
        F(hashMap);
    }

    public final int getType() {
        return 1612;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/deletelistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
    }
}
