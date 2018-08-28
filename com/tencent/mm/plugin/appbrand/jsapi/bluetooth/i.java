package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        boolean z = false;
        c.kB(126);
        x.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[]{lVar.mAppId});
        b tr = a.tr(lVar.mAppId);
        if (tr == null) {
            x.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(128, 130);
            return;
        }
        boolean aiB = b.aiB();
        if (tr.fLc != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = tr.fLc;
            if (bVar.fLI != null) {
                z = bVar.fLI.fMQ.get();
            }
        }
        x.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + aiB + ",discoveringState : " + z);
        Map hashMap2 = new HashMap();
        hashMap2.put("available", Boolean.valueOf(aiB));
        hashMap2.put("discovering", Boolean.valueOf(z));
        lVar.E(i, f("ok", hashMap2));
        c.kB(127);
    }
}
