package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    private static int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        p d = d(lVar);
        if (d == null) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "pageView is null");
            lVar.E(i, f("fail", null));
            return;
        }
        c E = b.E(lVar.mAppId, d.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "appBrandMapView is null, return");
            lVar.E(i, f("fail", null));
            return;
        }
        Map hashMap = new HashMap();
        f adw = E.fSW.adw();
        hashMap.put("latitude", Double.valueOf(adw.adG()));
        hashMap.put("longitude", Double.valueOf(adw.adH()));
        x.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[]{hashMap.toString()});
        lVar.E(i, f("ok", hashMap));
    }
}
