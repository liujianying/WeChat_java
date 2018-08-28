package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiIncludeMapPoints", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiIncludeMapPoints", "appBrandMapView is null, return");
            return false;
        }
        x.i("MicroMsg.JsApiIncludeMapPoints", "includeMapPoints, onUpdateView()");
        try {
            if (jSONObject.has("points")) {
                int i2;
                List arrayList = new ArrayList();
                String optString = jSONObject.optString("points");
                if (!bi.oW(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        arrayList.add(E.C(bi.getFloat(jSONObject2.optString("latitude"), 0.0f), bi.getFloat(jSONObject2.optString("longitude"), 0.0f)));
                    }
                }
                optString = jSONObject.optString("padding");
                if (bi.oW(optString)) {
                    i2 = 0;
                } else {
                    i2 = f.a(new JSONArray(optString), 0);
                }
                if (arrayList.size() > 0) {
                    E.fSW.d(arrayList, i2);
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[]{e});
            return false;
        }
    }
}
