package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiCancelDownloadTask extends a {
    public static final int CTRL_INDEX = 475;
    public static final String NAME = "cancelDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiCancelDownloadTask", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("downloadIdArray");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            x.e("MicroMsg.JsApiCancelDownloadTask", "doCancelDownloadTask fail, invalid downloadIdArray");
            lVar.E(i, f("fail", null));
            return;
        }
        AppBrandMainProcessService.a(new CancelDownloadTask(optJSONArray, this, lVar, i));
    }
}
