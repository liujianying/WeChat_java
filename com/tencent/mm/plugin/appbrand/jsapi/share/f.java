package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d != null) {
            d.D(com.tencent.mm.plugin.appbrand.menu.l.gjw, false);
        }
        lVar.E(i, f("ok", null));
    }
}
