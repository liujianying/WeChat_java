package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

public final class be extends a {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (lVar.fdO.fcu.fqL == optBoolean) {
            lVar.E(i, f("ok", null));
            return;
        }
        MenuDelegate_EnableDebug.e(lVar.getContext(), lVar.mAppId, optBoolean);
        lVar.E(i, f("ok", null));
    }
}
