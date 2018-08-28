package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateRequestTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            lVar.E(i, f("fail:requestTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bi.oW(optString2)) {
            x.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            lVar.E(i, f("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            c uL = e.alu().uL(lVar.mAppId);
            if (uL == null) {
                lVar.E(i, f("fail:no task", null));
                x.w("MicroMsg.JsApiOperateRequestTask", "request is null");
                return;
            }
            d uK = uL.uK(optString);
            if (uK == null) {
                lVar.E(i, f("fail:no task", null));
                x.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", new Object[]{optString});
                return;
            }
            uL.b(uK);
            lVar.E(i, f("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("requestTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            h a = new c.a().a(lVar);
            a.mData = optString2;
            a.ahM();
            x.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", new Object[]{optString});
        } else {
            lVar.E(i, f("fail:unknown operationType", null));
        }
    }
}
