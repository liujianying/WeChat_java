package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask extends a {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiQueryDownloadTask", "invoke");
        AppBrandMainProcessService.a(new QueryDownloadTask(this, lVar, i, jSONObject));
        b.f(lVar);
    }
}
