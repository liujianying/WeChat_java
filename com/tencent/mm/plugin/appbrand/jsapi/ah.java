package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class ah extends a {
    public static final int CTRL_INDEX = 10;
    public static final String NAME = "hideNavigationBarLoading";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        d.cD(false);
        lVar.E(i, f("ok", null));
    }
}
