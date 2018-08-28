package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class j extends c {
    public static final int CTRL_INDEX = 141;
    public static final String NAME = "moveToMapLocation";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiMoveToMapLocation", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiMoveToMapLocation", "appBrandMapView is null, return");
            return false;
        }
        x.i("MicroMsg.JsApiMoveToMapLocation", NAME);
        x.i("MicroMSg.AppBrandMapView", "mapId:%d moveToMapLocation", new Object[]{Integer.valueOf(E.mapId)});
        if (E.fSY != null && E.fSX) {
            E.fSW.animateTo(E.fSY.getLatitude(), E.fSY.getLongitude());
            x.d("MicroMSg.AppBrandMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[]{Double.valueOf(r4), Double.valueOf(r6)});
        }
        return true;
    }
}
