package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.e;
import org.json.JSONObject;

public final class ai extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "hideTabBar";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.page.l currentPage = lVar.fdO.fcz.getCurrentPage();
        if (currentPage instanceof e) {
            ((e) currentPage).getTabBar().di(jSONObject.optBoolean("animation", true));
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail:not TabBar page", null));
    }
}
