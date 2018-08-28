package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class f extends a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(25);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        x.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(27, 30);
        } else if (b.aiB()) {
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            long optLong = jSONObject.optLong("timeout", 20000);
            String optString = jSONObject.optString("deviceId");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.b(optString);
            bVar.Zq = optBoolean;
            bVar.fLy = optBoolean2;
            bVar.fLA = optBoolean3;
            bVar.fMf = optLong;
            tr.a(optString, bVar, new 1(this, r0, lVar, i));
        } else {
            x.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(27, 32);
        }
    }
}
