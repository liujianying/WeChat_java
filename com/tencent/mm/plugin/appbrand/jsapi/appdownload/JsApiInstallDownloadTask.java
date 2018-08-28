package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask extends a {
    public static final int CTRL_INDEX = 442;
    public static final String NAME = "installDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new InstallDownloadTask(this, lVar, i, jSONObject));
    }
}
