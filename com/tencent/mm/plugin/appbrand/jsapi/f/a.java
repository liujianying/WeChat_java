package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends c {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapCircles", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapCircles", "data is null");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiAddMapCircles", "appBrandMapView is null, return");
            return false;
        }
        try {
            if (jSONObject.has("circles")) {
                synchronized (E.fTe) {
                    Iterator it = E.fTe.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.appbrand.compat.a.b.b) it.next()).remove();
                    }
                    E.fTe.clear();
                }
                JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    float f = bi.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f2 = bi.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    int aQ = f.aQ(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int aQ2 = f.aQ(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int optInt = jSONObject2.optInt("radius");
                    float a = f.a(jSONObject2, "strokeWidth", 0.0f);
                    com.tencent.mm.plugin.appbrand.compat.a.b.c adz = E.fSW.adz();
                    adz.f((double) f, (double) f2);
                    adz.jO(optInt);
                    adz.jP(aQ);
                    adz.jQ((int) a);
                    adz.jR(aQ2);
                    com.tencent.mm.plugin.appbrand.compat.a.b.b a2 = E.fSW.a(adz);
                    synchronized (E.fTe) {
                        E.fTe.add(a2);
                    }
                    i2 = i3 + 1;
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[]{e});
            return false;
        }
    }
}
