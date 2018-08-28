package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiGetInstallState extends a {
    public static final int CTRL_INDEX = 439;
    public static final String NAME = "getInstallState";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiGetInstallState", "invoke");
        AppBrandMainProcessService.a(new GetInstallStateTask(this, lVar, i, jSONObject));
    }
}
