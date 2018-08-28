package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask extends a {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new PauseDownloadTask(this, lVar, i, jSONObject));
    }
}
