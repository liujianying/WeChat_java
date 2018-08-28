package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiWriteCommData extends a {
    public static final int CTRL_INDEX = 445;
    public static final String NAME = "writeCommData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new WriteCommDataTask(this, lVar, i, jSONObject));
    }
}
