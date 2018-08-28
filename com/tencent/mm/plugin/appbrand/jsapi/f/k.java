package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiRemoveMap", "removeMap appId:%s mapId:%d data:%s", new Object[]{pVar.mAppId, Integer.valueOf(k(jSONObject)), jSONObject});
        c E = com.tencent.mm.plugin.appbrand.jsapi.f.a.b.E(r0, pVar.hashCode(), r1);
        if (E != null) {
            ah.A(new 1(this, E));
        }
        super.a(pVar, jSONObject, i);
    }

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiRemoveMap", "data is null");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.f.a.b.F(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        return true;
    }
}
