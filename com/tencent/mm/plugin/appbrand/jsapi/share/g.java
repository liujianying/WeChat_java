package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 202;
    public static final String NAME = "showShareMenuWithShareTicket";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiShowShareMenuWithShareTicket", "invoke");
        p d = d(lVar);
        if (d != null) {
            d.D(com.tencent.mm.plugin.appbrand.menu.l.gjw, false);
            k lo = d.lo(com.tencent.mm.plugin.appbrand.menu.l.gjw);
            if (lo == null) {
                lVar.E(i, f("fail:menu item do not exist", null));
                return;
            }
            lo.fvX.p("enable_share_with_share_ticket", Boolean.valueOf(true));
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("ok", null));
    }
}
