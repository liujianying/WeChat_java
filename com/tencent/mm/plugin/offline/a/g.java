package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends h {
    public g(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put("method", str2);
        String str4 = "network";
        Object obj = ao.isWifi(ad.getContext()) ? "wifi" : ao.is3G(ad.getContext()) ? "3g" : ao.is2G(ad.getContext()) ? "2g" : ao.isWap(ad.getContext()) ? "wap" : ao.is4G(ad.getContext()) ? "4g" : "unknown";
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        F(hashMap);
    }

    public final int aBO() {
        return 122;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    public final int If() {
        return 1602;
    }
}
