package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = lVar.mAppId;
        jsApiGetStorageInfoTask.fFC = new 1(this, jsApiGetStorageInfoTask, lVar, i);
        jsApiGetStorageInfoTask.ahA();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
    }
}
