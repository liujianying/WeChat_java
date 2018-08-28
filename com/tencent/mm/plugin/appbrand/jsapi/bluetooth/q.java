package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class q extends a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(56);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            lVar.E(i, f("fail:data is null", null));
            c.bK(58, 59);
            return;
        }
        x.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(58, 61);
        } else if (b.aiB()) {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString("value");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("serial", true);
            f fVar = new f(optString2, optString3, optString4);
            fVar.Zq = optBoolean;
            fVar.fLy = false;
            fVar.fLA = optBoolean2;
            tr.a(optString, fVar, new 1(this, lVar, i));
        } else {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(58, 63);
        }
    }
}
