package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.n.13;
import org.json.JSONObject;

public final class ba extends a {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (lVar.fdO.fcv.foP.rH(optString)) {
            lVar.E(i, f("fail:can not redirect to a tab bar page", null));
            return;
        }
        n nVar = lVar.fdO.fcz;
        nVar.runOnUiThread(new 13(nVar, optString));
        lVar.E(i, f("ok", null));
    }
}
