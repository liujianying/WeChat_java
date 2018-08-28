package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            lVar.E(i, f("fail:downloadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bi.oW(optString2)) {
            x.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            lVar.E(i, f("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            com.tencent.mm.plugin.appbrand.k.a uI = b.alr().uI(lVar.mAppId);
            if (uI == null) {
                lVar.E(i, f("fail:no task", null));
                x.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                return;
            }
            com.tencent.mm.plugin.appbrand.k.a.b uF = uI.uF(optString);
            if (uF == null) {
                lVar.E(i, f("fail:no task", null));
                x.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[]{optString});
                return;
            }
            uI.a(uF);
            lVar.E(i, f("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("downloadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            h a = new b.a().a(lVar);
            a.mData = optString2;
            a.ahM();
            x.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            lVar.E(i, f("fail:unknown operationType", null));
        }
    }
}
