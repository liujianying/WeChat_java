package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight extends a {
    public static final int CTRL_INDEX = 440;
    public static final String NAME = "addDownloadTaskStraight";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(this, lVar, i, jSONObject));
        b.f(lVar);
    }
}
