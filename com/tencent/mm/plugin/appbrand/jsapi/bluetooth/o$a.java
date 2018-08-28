package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class o$a extends h {
    private static final int CTRL_INDEX = 190;
    private static final String NAME = "onBluetoothDeviceFound";
    private static JSONObject fLm = new JSONObject();
    private static o$a fLr = new o$a();

    private o$a() {
    }

    public static synchronized void a(l lVar, d dVar) {
        synchronized (o$a.class) {
            if (lVar == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
            } else {
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray.put(dVar.ahS());
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
                }
                try {
                    fLm.remove("devices");
                    fLm.put("devices", jSONArray);
                } catch (JSONException e2) {
                    x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e2});
                }
                if (lVar == null) {
                    x.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                } else {
                    h a = fLr.a(lVar);
                    a.mData = fLm.toString();
                    a.ahM();
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[]{fLm.toString()});
                }
            }
        }
    }

    public static synchronized void a(l lVar, List<d> list) {
        synchronized (o$a.class) {
            if (lVar == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
            } else {
                JSONArray jSONArray = new JSONArray();
                for (d ahS : list) {
                    try {
                        jSONArray.put(ahS.ahS());
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
                    }
                }
                try {
                    fLm.remove("devices");
                    fLm.put("devices", jSONArray);
                } catch (JSONException e2) {
                    x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e2});
                }
                if (lVar == null) {
                    x.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                } else {
                    h a = fLr.a(lVar);
                    a.mData = fLm.toString();
                    a.ahM();
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[]{fLm.toString()});
                }
            }
        }
    }
}
