package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bg extends a {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiSetMenuStyle", "data is null");
            return;
        }
        String optString = jSONObject.optString("style");
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail view is null", null));
            return;
        }
        if (optString.equalsIgnoreCase("dark")) {
            d.vb("dark");
        } else if (optString.equalsIgnoreCase("light")) {
            d.vb("light");
        } else {
            lVar.E(i, f("fail invalid style " + optString, null));
            x.e("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", new Object[]{optString});
            return;
        }
        lVar.E(i, f("ok", null));
    }
}
