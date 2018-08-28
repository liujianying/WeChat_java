package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanFilterCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        List list = null;
        c.kB(11);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
            lVar.E(i, f("fail:invalid data", null));
            c.bK(13, 14);
            return;
        }
        x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[]{lVar.mAppId, jSONObject});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(13, 16);
        } else if (b.aiB()) {
            boolean optBoolean = jSONObject.optBoolean("allowDuplicatesKey");
            int optInt = jSONObject.optInt("interval");
            String optString = jSONObject.optString("", "middle");
            if (jSONObject.has("services")) {
                list = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("services"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        list.add(new ScanFilterCompat.a().a(ParcelUuid.fromString(jSONArray.getString(i2).toUpperCase())).aix());
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                    hashMap = new HashMap();
                    hashMap.put("isDiscovering", Boolean.valueOf(false));
                    hashMap.put("errCode", Integer.valueOf(10004));
                    lVar.E(i, f("fail:no service", hashMap));
                    c.kB(13);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a();
            aVar.djl = optInt;
            aVar.fLu = optBoolean;
            aVar.fLD = optString;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a ais = aVar.ais();
            if (tr.fLc != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[]{ais});
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a(ais);
            }
            1 1 = new 1(this, lVar, i);
            2 2 = new 2(this, lVar);
            if (tr.fLc != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = tr.fLc;
                if (bVar.fLI != null) {
                    bVar.fLI.a(1, list, 2);
                }
            }
            c.a(lVar, true, true);
        } else {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(13, 18);
        }
    }
}
