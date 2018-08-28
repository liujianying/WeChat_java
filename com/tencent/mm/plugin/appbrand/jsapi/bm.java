package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.a$e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.e;
import org.json.JSONObject;

public final class bm extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarStyle";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        a$e a_e = lVar.fdO.fcv.foP;
        String optString = jSONObject.optString("color", a_e.dxh);
        String optString2 = jSONObject.optString("selectedColor", a_e.fpb);
        String optString3 = jSONObject.optString("backgroundColor", a_e.fpc);
        String optString4 = jSONObject.optString("borderStyle", a_e.fpd);
        com.tencent.mm.plugin.appbrand.page.l currentPage = lVar.fdO.fcz.getCurrentPage();
        if (currentPage instanceof e) {
            ((e) currentPage).getTabBar().h(optString, optString2, optString3, optString4);
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail:not TabBar page", null));
    }
}
