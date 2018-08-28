package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiLaunchMiniProgram extends a {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        String optString = jSONObject.optString("appId", null);
        if (bi.oW(optString)) {
            lVar.E(i, f("fail:invalid data", null));
        } else if (optString.equals(lVar.mAppId)) {
            lVar.E(i, f("fail target appId is the same as the caller appId", null));
        } else {
            String optString2 = jSONObject.optString("path", null);
            String optString3 = jSONObject.optString("extraData", null);
            if (!(lVar.fdO.fcu.frm.fih == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            ah.A(new 1(this, lVar, optString, i2, optString2, optString3, i));
        }
    }
}
