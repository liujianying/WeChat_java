package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class g extends a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(151);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            lVar.E(i, f("fail:invalid data", null));
            c.bK(153, 154);
            return;
        }
        x.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(153, 156);
        } else if (b.aiB()) {
            List<c> bn = tr.bn(jSONObject.optString("deviceId"), jSONObject.optString("serviceId"));
            Map hashMap2 = new HashMap();
            if (bn == null || bn.size() <= 0) {
                x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
                hashMap2.put("errCode", Integer.valueOf(10005));
                lVar.E(i, f("fail:no characteristic", hashMap2));
                c.bK(153, 159);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (c cVar : bn) {
                try {
                    if (cVar.fMp == null) {
                        boolean z;
                        cVar.fMp = new JSONObject();
                        cVar.fMp.put("uuid", cVar.fMk);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("read", cVar.fMl);
                        String str = "write";
                        if (cVar.fMm || cVar.fMn) {
                            z = true;
                        } else {
                            z = false;
                        }
                        jSONObject2.put(str, z);
                        jSONObject2.put("notify", cVar.dBn);
                        jSONObject2.put("indicate", cVar.fMo);
                        cVar.fMp.put("properties", jSONObject2);
                    }
                    jSONArray.put(cVar.fMp);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[]{e.getMessage()});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("characteristics", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e2, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[]{jSONObject3.toString()});
            lVar.E(i, jSONObject3.toString());
            c.kB(152);
        } else {
            x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(153, 158);
        }
    }
}
