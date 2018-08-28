package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = lVar.mAppId;
        jsApiRemoveStorageTask.aAL = optString;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        lVar.E(i, f("ok", null));
    }
}
