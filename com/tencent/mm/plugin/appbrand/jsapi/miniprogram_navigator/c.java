package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.6;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
        g runtime = cVar.getRuntime();
        runtime.fcq.runOnUiThread(new 6(runtime, MiniProgramNavigationBackResult.a(optJSONObject, optJSONObject2)));
    }
}
