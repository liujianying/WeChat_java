package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.compat.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    private static int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapRegion", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        p d = d(lVar);
        if (d == null) {
            x.e("MicroMsg.JsApiGetMapRegion", "pageView is null");
            lVar.E(i, f("fail", null));
            return;
        }
        c E = b.E(lVar.mAppId, d.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiGetMapRegion", "appBrandMapView is null, return");
            lVar.E(i, f("fail", null));
            return;
        }
        g adL = E.fSW.adx().adK().adL();
        com.tencent.mm.plugin.appbrand.compat.a.b.f adE = adL.adE();
        com.tencent.mm.plugin.appbrand.compat.a.b.f adF = adL.adF();
        Map hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(adE.adG()));
        hashMap.put("longitude", Double.valueOf(adE.adH()));
        Map hashMap2 = new HashMap();
        hashMap2.put("latitude", Double.valueOf(adF.adG()));
        hashMap2.put("longitude", Double.valueOf(adF.adH()));
        Map hashMap3 = new HashMap();
        hashMap3.put("southwest", hashMap);
        hashMap3.put("northeast", hashMap2);
        x.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[]{hashMap3.toString()});
        lVar.E(i, f("ok", hashMap3));
    }
}
