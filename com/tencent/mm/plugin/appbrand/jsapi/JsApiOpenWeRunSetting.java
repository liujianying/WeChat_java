package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting fGv;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        boolean z = true;
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        this.fGv = new OpenWeRunSetting(this, lVar, i, z);
        this.fGv.ahA();
        AppBrandMainProcessService.a(this.fGv);
    }
}
