package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapControls", "data is null");
            return false;
        }
        x.d("MicroMsg.JsApiAddMapControls", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = com.tencent.mm.plugin.appbrand.jsapi.f.a.b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiAddMapControls", "appBrandMapView is null, return");
            return false;
        }
        try {
            if (jSONObject.has("controls")) {
                E.ajk();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    com.tencent.mm.plugin.appbrand.jsapi.f.a.c.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.f.a.c.b();
                    bVar.fTs = jSONObject2.optString("iconPath");
                    bVar.fTt = jSONObject2.optBoolean("clickable");
                    bVar.data = jSONObject2.optString("data");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("position");
                    int a = f.a(jSONObject3, "left", 0);
                    int a2 = f.a(jSONObject3, "top", 0);
                    bVar.left = a;
                    bVar.top = a2;
                    if (jSONObject3.has("width")) {
                        bVar.width = f.a(jSONObject3, "width", 0);
                    }
                    if (jSONObject3.has("height")) {
                        bVar.height = f.a(jSONObject3, "height", 0);
                    }
                    if (jSONObject2.optBoolean("clickable")) {
                        E.a(bVar, new 1(this, i, pVar));
                    } else {
                        E.a(bVar, null);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapControls", "parse circles error, exception : %s", new Object[]{e});
            return false;
        }
    }
}
