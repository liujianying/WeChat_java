package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends n {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    public final String a(l lVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bi.oW(optString)) {
            return f("fail", null);
        }
        JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = lVar.mAppId;
        jsApiGetStorageTask.aAL = optString;
        AppBrandMainProcessService.b(jsApiGetStorageTask);
        optString = jsApiGetStorageTask.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put("data", jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
        hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
        return f(optString, hashMap);
    }
}
