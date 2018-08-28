package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends c {
    public static final int CTRL_INDEX = 343;
    public static final String NAME = "removeMapMarkers";

    protected final int k(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "get mapId error, exception : %s", new Object[]{e});
            return i;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (pVar.agU().E(i, false) == null) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
            return false;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
            if (E == null) {
                x.e("MicroMsg.JsApiRemoveMapMarkers", "appBrandMapView is null, return");
                return false;
            }
            x.i("MicroMsg.JsApiRemoveMapMarkers", "removeMapMarkers, data:%s", new Object[]{jSONObject.toString()});
            if (jSONObject.has("markers")) {
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        x.i("MicroMSg.AppBrandMapView", "mapId:%d removeMarker markerId:%s", new Object[]{Integer.valueOf(E.mapId), string});
                        synchronized (E.fTa) {
                            e eVar = (e) E.fTa.get(string);
                            if (eVar == null) {
                                x.w("MicroMSg.AppBrandMapView", "marker:%s is null", new Object[]{string});
                            } else {
                                eVar.fTv.remove();
                                if (eVar.fTw != null) {
                                    if (eVar.fTw.getMarkerView() != null && (eVar.fTw.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.e)) {
                                        a.a((com.tencent.mm.plugin.appbrand.widget.e.e) eVar.fTw.getMarkerView());
                                    }
                                    eVar.fTw.remove();
                                    E.fTa.remove(string + "#label");
                                }
                                E.fTa.remove(string);
                            }
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", e, "", new Object[0]);
                    return false;
                }
            }
            return true;
        }
    }
}
