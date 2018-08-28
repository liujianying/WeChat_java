package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = lVar.mAppId;
        AppBrandMainProcessService.a(jsApiClearStorageTask);
        lVar.E(i, f("ok", null));
    }
}
