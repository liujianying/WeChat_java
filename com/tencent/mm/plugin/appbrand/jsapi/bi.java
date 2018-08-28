package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class bi extends a {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("title");
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        d.sZ(optString);
        lVar.E(i, f("ok", null));
    }
}
