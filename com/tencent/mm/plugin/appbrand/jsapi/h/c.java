package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    protected final String ajr() {
        StringBuilder stringBuilder = new StringBuilder();
        e.alu();
        return stringBuilder.append(e.alq()).toString();
    }

    protected final String ajs() {
        return "requestTaskId";
    }

    public final void a(l lVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        1 1 = new 1(this, System.currentTimeMillis(), lVar, str);
        String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiCreateRequestTask", "url is null");
            a(lVar, str, "url is null or nil");
            return;
        }
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        a aVar = lVar.fdO.fcv;
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 0);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        if (appBrandSysConfig.fqT <= 0) {
            x.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a = i.a(jSONObject, appBrandSysConfig);
        boolean z = i.c(lVar.fdO.fct) && jSONObject.optBoolean("__skipDomainCheck__");
        boolean a2 = i.a(appBrandSysConfig, z);
        if (!a2 || i.b(appBrandSysConfig.frd, optString)) {
            com.tencent.mm.plugin.appbrand.k.c cVar;
            if (e.alu().uL(lVar.mAppId) == null) {
                p d = d(lVar);
                String str2 = null;
                if (!(d == null || d.gns == null)) {
                    str2 = d.gns.getUserAgentString();
                }
                com.tencent.mm.plugin.appbrand.k.c cVar2 = new com.tencent.mm.plugin.appbrand.k.c(lVar.mAppId, str2, lVar.fdO.fcu);
                e alu = e.alu();
                String str3 = lVar.mAppId;
                if (!alu.fNX.containsKey(str3)) {
                    alu.fNX.put(str3, cVar2);
                }
                cVar = cVar2;
            } else {
                cVar = e.alu().uL(lVar.mAppId);
            }
            x.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", new Object[]{optString});
            if (cVar == null) {
                a(lVar, str, "create request error");
                return;
            } else if (a2) {
                cVar.a(lVar, this, optInt, jSONObject, a, appBrandSysConfig.frd, 1, str, NAME);
                return;
            } else {
                x.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                cVar.a(lVar, this, optInt, jSONObject, a, null, 1, str, NAME);
                return;
            }
        }
        x.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", new Object[]{optString});
        a(lVar, str, "url not in domain list");
    }

    private static void a(l lVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new a().a(lVar);
        a.mData = jSONObject;
        a.ahM();
    }
}
