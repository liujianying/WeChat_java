package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class b extends n {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    public final String a(l lVar, JSONObject jSONObject) {
        JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = lVar.mAppId;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        return f("ok", null);
    }
}
