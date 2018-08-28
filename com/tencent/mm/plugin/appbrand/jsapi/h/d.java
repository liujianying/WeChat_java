package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.k.j;
import com.tencent.mm.plugin.appbrand.k.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";

    protected final String ajr() {
        StringBuilder stringBuilder = new StringBuilder();
        k.aly();
        return stringBuilder.append(k.alq()).toString();
    }

    protected final String ajs() {
        return "socketTaskId";
    }

    public final void a(final l lVar, JSONObject jSONObject, final String str) {
        j uT = k.aly().uT(lVar.mAppId);
        if (uT == null) {
            p d = d(lVar);
            String str2 = null;
            if (!(d == null || d.gns == null)) {
                str2 = d.gns.getUserAgentString();
            }
            j jVar = new j(lVar.mAppId, str2, lVar.fdO.fcu);
            k aly = k.aly();
            String str3 = lVar.mAppId;
            if (!aly.fNX.containsKey(str3)) {
                aly.fNX.put(str3, jVar);
            }
            uT = jVar;
        }
        2 2 = new 2(this, lVar, new a() {
            public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
                if (aVar == com.tencent.mm.plugin.appbrand.b.a.fjg || aVar == com.tencent.mm.plugin.appbrand.b.a.fjh) {
                    j jVar = uT;
                    com.tencent.mm.plugin.appbrand.s.a.a uS = uT.uS(str);
                    if (uS != null) {
                        try {
                            x.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                            uS.close();
                        } catch (Exception e) {
                            x.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
                            j.c(uS);
                        }
                        jVar.b(uS);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("reason", "interrupted");
                    hashMap.put("socketTaskId", str);
                    hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "close");
                    String jSONObject = new JSONObject(hashMap).toString();
                    h a = new a().a(lVar);
                    a.mData = jSONObject;
                    a.ahM();
                }
            }
        }, str);
        com.tencent.mm.plugin.appbrand.config.a aVar = lVar.fdO.fcv;
        String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(optString)) {
            x.i("MicroMsg.JsApiCreateSocketTask", "url is null");
            a(lVar, str, "url is null");
            return;
        }
        boolean z;
        x.i("MicroMsg.JsApiCreateSocketTask", "url is " + optString);
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        Map a = i.a(jSONObject, appBrandSysConfig);
        if (i.c(lVar.fdO.fct) && jSONObject.optBoolean("__skipDomainCheck__")) {
            z = true;
        } else {
            z = false;
        }
        if (!i.a(appBrandSysConfig, z) || i.a(appBrandSysConfig.fre, optString, appBrandSysConfig.fqY)) {
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = i.a(appBrandSysConfig, aVar, 1);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            uT.a(str, optInt, jSONObject, a, 2);
            x.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s ,appid: %s", new Object[]{optString, appBrandSysConfig.appId});
            return;
        }
        x.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[]{optString});
        a(lVar, str, "url not in domain list");
    }

    private static JSONObject a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        Iterator aoQ = fVar.aoQ();
        while (aoQ.hasNext()) {
            try {
                String str = (String) aoQ.next();
                jSONObject.put(str, fVar.wa(str));
            } catch (JSONException e) {
                x.w("MicroMsg.JsApiCreateSocketTask", "JSONException " + e);
            }
        }
        return jSONObject;
    }

    private static void a(l lVar, String str, String str2) {
        Object obj;
        if (bi.oW(str2)) {
            obj = "fail";
        } else {
            obj = "fail:" + str2;
        }
        Map hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "error");
        hashMap.put("errMsg", obj);
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new a().a(lVar);
        a.mData = jSONObject;
        a.ahM();
        x.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[]{jSONObject});
    }
}
