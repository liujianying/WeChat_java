package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class am extends a {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        lVar.fdO.fcz.ko(jSONObject.optInt("delta", 1));
        lVar.E(i, f("ok", null));
    }
}
