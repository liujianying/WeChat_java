package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
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
public final class k extends a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(191);
        x.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        x.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getBLEDeviceCharacteristics data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(193, 195);
        } else if (b.aiB()) {
            List<d> air = tr.air();
            if (air == null) {
                x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                lVar.E(i, f("fail", null));
                c.bK(193, bh.CTRL_INDEX);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (d dVar : air) {
                String str = dVar.byN;
                String str2 = dVar.name;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", str);
                    jSONObject2.put("name", str2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[]{e});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e2, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[]{jSONObject3.toString()});
            lVar.E(i, jSONObject3.toString());
            c.kB(192);
        } else {
            x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(193, 197);
        }
    }
}
