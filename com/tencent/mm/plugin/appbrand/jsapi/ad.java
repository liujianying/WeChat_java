package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Map hashMap = new HashMap();
        if (!ao.isConnected(lVar.getContext())) {
            hashMap.put("networkType", "none");
        } else if (ao.is2G(lVar.getContext())) {
            hashMap.put("networkType", "2g");
        } else if (ao.is3G(lVar.getContext())) {
            hashMap.put("networkType", "3g");
        } else if (ao.is4G(lVar.getContext())) {
            hashMap.put("networkType", "4g");
        } else if (ao.isWifi(lVar.getContext())) {
            hashMap.put("networkType", TencentExtraKeys.LOCATION_SOURCE_WIFI);
        } else {
            hashMap.put("networkType", "unknown");
        }
        lVar.E(i, f("ok", hashMap));
    }
}
