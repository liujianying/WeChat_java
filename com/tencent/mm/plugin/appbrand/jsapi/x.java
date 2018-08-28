package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class x extends a {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                pVar.cE(false);
            } else {
                pVar.cE(pVar.fdO.fcv.rG(pVar.getURL()).fpo);
            }
            pVar.E(i, f("ok", null));
            return;
        }
        pVar.E(i, f("ok", null));
    }
}
