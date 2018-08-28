package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 197;
    private static final String NAME = "setStatusBarStyle";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("color", "");
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        if (optString.equals("white")) {
            d.tb("white");
        } else if (optString.equals("black")) {
            d.tb("black");
        }
        lVar.E(i, f("ok", null));
    }
}
