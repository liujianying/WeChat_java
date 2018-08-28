package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class h extends n {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    public final String a(l lVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bi.oW(optString)) {
            return f("fail", null);
        }
        JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = lVar.mAppId;
        jsApiRemoveStorageTask.aAL = optString;
        AppBrandMainProcessService.b(jsApiRemoveStorageTask);
        return f("ok", null);
    }
}
