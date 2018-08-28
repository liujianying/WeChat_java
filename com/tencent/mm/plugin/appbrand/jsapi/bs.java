package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bs extends a {
    public static final int CTRL_INDEX = 65;
    public static final String NAME = "systemLog";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("AppBrandLog." + lVar.mAppId, jSONObject.optString("message"));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        x.i("AppBrandLog." + pVar.mAppId, jSONObject.optString("message"));
    }
}
