package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 241;
    private static final String NAME = "setTopBarText";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandStickyBannerLogic.a.bO(lVar.mAppId, jSONObject.optString("text"));
        lVar.E(i, f("ok", null));
        e.a(lVar.mAppId, new 1(this, lVar));
    }
}
