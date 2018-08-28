package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        ah.A(new 1(this, lVar));
        lVar.E(i, f("ok", null));
    }
}
