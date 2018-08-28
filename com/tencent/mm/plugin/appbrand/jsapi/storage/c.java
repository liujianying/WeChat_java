package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = lVar.mAppId;
        jsApiGetStorageTask.aAL = optString;
        jsApiGetStorageTask.fFC = new 1(this, jsApiGetStorageTask, lVar, i, currentTimeMillis);
        jsApiGetStorageTask.ahA();
        AppBrandMainProcessService.a(jsApiGetStorageTask);
    }
}
