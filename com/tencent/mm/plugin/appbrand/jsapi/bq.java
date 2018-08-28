package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class bq extends a {
    public static final int CTRL_INDEX = 12;
    public static final String NAME = "stopPullDownRefresh";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        d.agZ();
        lVar.E(i, f("ok", null));
    }
}
