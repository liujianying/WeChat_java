package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends a {
    public j(int i) {
        super("reportIDKey", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.aA(a(false, "dataArray is null", null));
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                h.mEJ.a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        aVar2.aA(a(true, "", null));
    }
}
