package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.k.f;
import com.tencent.mm.plugin.appbrand.k.g;
import com.tencent.mm.plugin.appbrand.k.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateUploadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            lVar.E(i, f("fail:uploadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bi.oW(optString2)) {
            x.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            lVar.E(i, f("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            f uN = h.alw().uN(lVar.mAppId);
            if (uN == null) {
                x.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                lVar.E(i, f("fail:no task", null));
                return;
            }
            g uM = uN.uM(optString);
            if (uM == null) {
                x.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[]{optString});
                lVar.E(i, f("fail:no task", null));
                return;
            }
            uN.a(uM);
            lVar.E(i, f("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("uploadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.h a = new e.a().a(lVar);
            a.mData = optString2;
            a.ahM();
            x.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            lVar.E(i, f("fail:unknown operationType", null));
        }
    }
}
