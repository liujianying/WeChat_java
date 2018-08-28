package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bj extends a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float fHg = Float.NaN;
    float fHh;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            return;
        }
        ah.A(new 1(this, jSONObject, lVar, i));
    }
}
