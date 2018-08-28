package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 463;
    private static final String NAME = "updateKeyboard";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        ah.A(new 1(this, lVar, jSONObject.optString("value"), i));
    }
}
