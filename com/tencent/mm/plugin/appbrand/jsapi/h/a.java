package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends n {
    public abstract void a(l lVar, JSONObject jSONObject, String str);

    public abstract String ajr();

    public abstract String ajs();

    public final String a(l lVar, JSONObject jSONObject) {
        String ajr = ajr();
        Map hashMap = new HashMap();
        hashMap.put(ajs(), ajr);
        lVar.fdP.fwr.post(new 1(this, lVar, jSONObject, ajr));
        return f("ok", hashMap);
    }
}
