package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiUpdateMap", "data is null");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiUpdateMap", "appBrandMapView is null, return");
            return false;
        }
        int i2;
        float f;
        if (jSONObject.has("scale")) {
            x.i("MicroMSg.AppBrandMapView", "mapId:%d zoomTo scale:%d", new Object[]{Integer.valueOf(E.mapId), Integer.valueOf(jSONObject.optInt("scale", 16))});
            E.fSW.jS(i2);
        }
        if (jSONObject.has("centerLatitude") && jSONObject.has("centerLongitude")) {
            f = bi.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
            float f2 = bi.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
            if (Math.abs(f) <= 90.0f && Math.abs(f2) <= 180.0f) {
                x.i("MicroMSg.AppBrandMapView", "mapId:%d setCenter", new Object[]{Integer.valueOf(E.mapId)});
                E.fSW.setCenter((double) f, (double) f2);
            }
        }
        try {
            if (jSONObject.has("covers")) {
                E.ajm();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    float f3 = bi.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f4 = bi.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    String optString = jSONObject2.optString("iconPath");
                    f = (float) jSONObject2.optDouble("rotate", 0.0d);
                    d dVar = new d();
                    double d = (double) f3;
                    double d2 = (double) f4;
                    dVar.latitude = d;
                    dVar.longitude = d2;
                    dVar.fTs = optString;
                    dVar.rotate = f;
                    E.a(dVar);
                    i2 = i3 + 1;
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[]{e});
            return false;
        }
    }
}
