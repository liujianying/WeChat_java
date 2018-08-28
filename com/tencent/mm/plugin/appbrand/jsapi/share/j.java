package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_INDEX = 464;
    public static final String NAME = "updateShareMenuUpdatable";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d != null) {
            k lo = d.lo(com.tencent.mm.plugin.appbrand.menu.l.gjw);
            if (lo == null) {
                lVar.E(i, f("fail:menu item do not exist", null));
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("updatable", false);
            String optString = jSONObject.optString("templateId", "");
            lo.fvX.p("enable_share_with_updateable_msg", Boolean.valueOf(optBoolean));
            lo.fvX.p("enable_share_with_updateable_msg_template_id", optString);
            lVar.E(i, f("ok", null));
            x.i("MicroMsg.JsApiUpdateShareMenuUpdatable", "update share menu updatable(%s)", new Object[]{Boolean.valueOf(optBoolean)});
            return;
        }
        lVar.E(i, f("fail", null));
    }
}
