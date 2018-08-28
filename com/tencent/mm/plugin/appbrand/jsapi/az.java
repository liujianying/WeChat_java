package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class az extends a {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        lVar.fdO.fcz.V(jSONObject.optString("url"), false);
        lVar.E(i, f("ok", null));
    }
}
