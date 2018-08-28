package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h extends a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(136);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
            lVar.E(i, f("fail:invalid data", null));
            c.bK(138, 139);
            return;
        }
        x.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(138, 141);
        } else if (b.aiB()) {
            List<e> tt = tr.tt(jSONObject.optString("deviceId"));
            Map hashMap2 = new HashMap();
            if (tt == null || tt.size() <= 0) {
                x.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                hashMap2.put("errCode", Integer.valueOf(10004));
                lVar.E(i, f("fail:no service", hashMap2));
                c.bK(138, com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (e eVar : tt) {
                if (bi.oW(eVar.fMk)) {
                    x.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                } else {
                    try {
                        if (eVar.fMp == null) {
                            eVar.fMp = new JSONObject();
                            eVar.fMp.put("uuid", eVar.fMk);
                            eVar.fMp.put("isPrimary", eVar.fMu);
                        }
                        jSONArray.put(eVar.fMp);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[]{e.getMessage()});
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("services", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e2, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[]{jSONObject2.toString()});
            lVar.E(i, jSONObject2.toString());
            c.kB(137);
        } else {
            x.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(138, 145);
        }
    }
}
