package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class l extends a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";
    public static String fLh = "notification";
    public static String fLi = "indication";

    public final void a(com.tencent.mm.plugin.appbrand.l lVar, JSONObject jSONObject, int i) {
        c.kB(71);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            lVar.E(i, f("fail:data is null", null));
            c.bK(73, 74);
            return;
        }
        x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(73, 76);
        } else if (b.aiB()) {
            c cVar;
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("state");
            String optString4 = jSONObject.optString("type", fLi);
            boolean optBoolean2 = jSONObject.optBoolean("debug", false);
            boolean optBoolean3 = jSONObject.optBoolean("mainThread", false);
            boolean optBoolean4 = jSONObject.optBoolean("serial", true);
            if (tr.fLc != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = tr.fLc;
                if (bVar.fLH != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c cVar2 = bVar.fLH;
                    if (cVar2.fLQ.get(optString) != null) {
                        d dVar = (d) cVar2.fLQ.get(optString);
                        if (dVar.fLV == null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
                        } else if (bi.oW(optString2) || bi.oW(optString3)) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] serviceId is null, err", new Object[0]);
                        } else if (!b.tv(optString2)) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                        } else if (b.tv(optString3)) {
                            BluetoothGattService service = dVar.fLV.getService(UUID.fromString(optString2));
                            if (service == null) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(optString3));
                                if (characteristic == null) {
                                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] characteristics is null, err", new Object[0]);
                                } else {
                                    c cVar3 = new c();
                                    cVar3.fMk = characteristic.getUuid().toString().toUpperCase();
                                    int properties = characteristic.getProperties();
                                    cVar3.fMl = b.kE(properties);
                                    cVar3.fMm = b.kF(properties);
                                    cVar3.fMn = b.kG(properties);
                                    cVar3.dBn = b.kH(properties);
                                    cVar3.fMo = b.kI(properties);
                                    cVar = cVar3;
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
                        }
                    }
                }
                cVar = null;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10005));
                lVar.E(i, f("fail:no characteristic", hashMap));
                c.kB(73);
                return;
            }
            boolean z = (cVar.dBn && !cVar.fMo) || (cVar.dBn && cVar.fMo && optString4.toLowerCase().equals(fLh));
            boolean z2 = (!cVar.dBn && cVar.fMo) || (cVar.dBn && cVar.fMo && optString4.toLowerCase().equals(fLi));
            x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[]{r5, Boolean.valueOf(z), Boolean.valueOf(z2)});
            if (z) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.d dVar2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.d(optString2, optString3, optBoolean);
                dVar2.Zq = optBoolean2;
                dVar2.fLy = optBoolean3;
                dVar2.fLA = optBoolean4;
                tr.a(optString, dVar2, new 1(this, lVar, i));
            } else if (z2) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.c cVar4 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.c(optString2, optString3, optBoolean);
                cVar4.Zq = optBoolean2;
                cVar4.fLy = optBoolean3;
                cVar4.fLA = optBoolean4;
                tr.a(optString, cVar4, new 2(this, r5, lVar, i));
            } else {
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10007));
                lVar.E(i, f("fail", hashMap));
                c.bK(73, 82);
            }
        } else {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(73, 79);
        }
    }
}
