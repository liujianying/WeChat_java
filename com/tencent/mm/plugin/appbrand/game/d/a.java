package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        b rJ = d.rJ(jSONObject.optString("value", null));
        if (rJ == null) {
            lVar.E(i, f("fail", null));
        } else if (lVar.fdO == null || lVar.fdO.fcq == null) {
            lVar.E(i, f("fail", null));
        } else {
            d.b(lVar.fdO.fcq).a(lVar.fdO.fcq, rJ, new 1(this, lVar, i));
        }
    }
}
