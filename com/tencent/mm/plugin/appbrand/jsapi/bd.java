package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_INDEX = 454;
    public static final String NAME = "setBackgroundTextStyle";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, "fail");
            return;
        }
        d.getContentView().post(new 1(this, d, jSONObject.optString("textStyle", "ignore")));
        lVar.E(i, f("ok", null));
    }
}
