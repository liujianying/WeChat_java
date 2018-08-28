package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapScale";

    private static int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapScale", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        p d = d(lVar);
        if (d == null) {
            x.e("MicroMsg.JsApiGetMapScale", "pageView is null");
            lVar.E(i, f("fail", null));
            return;
        }
        c E = b.E(lVar.mAppId, d.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiGetMapScale", "appBrandMapView is null, return");
            lVar.E(i, f("fail", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("scale", Integer.valueOf(E.fSW.getZoomLevel()));
        x.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", new Object[]{hashMap.toString()});
        lVar.E(i, f("ok", hashMap));
    }
}
