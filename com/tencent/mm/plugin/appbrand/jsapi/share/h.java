package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 211;
    public static final String NAME = "updateShareMenuDynamic";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d != null) {
            k lo = d.lo(com.tencent.mm.plugin.appbrand.menu.l.gjw);
            if (lo == null) {
                lVar.E(i, f("fail:menu item do not exist", null));
                return;
            }
            lo.fvX.p("enable_share_dynamic", Boolean.valueOf(jSONObject.optBoolean("isDynamic", false)));
            lVar.E(i, f("ok", null));
            x.i("MicroMsg.JsApiUpdateShareMenuDynamic", "update share menu dynamic(%s)", new Object[]{Boolean.valueOf(r1)});
            return;
        }
        lVar.E(i, f("fail", null));
    }
}
