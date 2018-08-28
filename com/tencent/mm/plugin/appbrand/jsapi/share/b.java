package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 203;
    public static final String NAME = "hideShareMenu";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiHideShareMenu", "invoke");
        p d = d(lVar);
        if (d != null) {
            d.D(com.tencent.mm.plugin.appbrand.menu.l.gjw, true);
        }
        lVar.E(i, f("ok", null));
    }
}
