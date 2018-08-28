package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 423;
    private static final String NAME = "sendRedPacket";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Map hashMap;
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiSendRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            lVar.E(i, f("fail:system error {{data is null}}", hashMap));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            x.i("MicroMsg.JsApiSendRedPacket", "scope is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            lVar.E(i, f("fail:system error {{scope is nil}}", hashMap));
            return;
        }
        new a(this, lVar, d(lVar), jSONObject, i).run();
    }
}
