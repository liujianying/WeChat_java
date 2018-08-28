package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_INDEX = 453;
    public static final String NAME = "setBackgroundColor";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, "fail");
            return;
        }
        long vF = j.vF(jSONObject.optString("backgroundColor", ""));
        if (vF == -1) {
            lVar.E(i, f("fail", null));
            return;
        }
        d.getContentView().post(new 1(this, d, vF));
        lVar.E(i, f("ok", null));
    }
}
