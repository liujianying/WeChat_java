package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bi;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends ab {
    public String kLf;
    public String kPS;

    public ac(String str, String str2, String str3, String str4) {
        this.kPS = str3;
        this.kLf = str2;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(bi.oV(str2)));
        hashMap.put("ver", str4);
        F(hashMap);
    }

    public final int getType() {
        return 1682;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
