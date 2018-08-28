package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends n {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    public final String a(l lVar, JSONObject jSONObject) {
        JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = lVar.mAppId;
        AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("keys", jsApiGetStorageInfoTask.fZr);
        hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
        hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.limit));
        return f("ok", hashMap);
    }
}
