package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class j extends n {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    public final String a(l lVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        if (bi.oW(optString)) {
            return f("fail", null);
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > lVar.fdO.fcu.frn.fpI) {
            return f("fail:entry size limit reached", null);
        }
        String str = "fail";
        JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = lVar.mAppId;
        jsApiSetStorageTask.E(optString, optString2, optString3);
        if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
            str = jsApiSetStorageTask.result;
        }
        return f(str, null);
    }
}
