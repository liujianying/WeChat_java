package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONException;
import org.json.JSONObject;

class m$a extends h {
    private static final int CTRL_INDEX = 187;
    private static final String NAME = "onBLECharacteristicValueChange";
    private static m$a fLl = new m$a();
    private static JSONObject fLm = new JSONObject();

    private m$a() {
    }

    public static synchronized void a(l lVar, String str, String str2, String str3, String str4) {
        synchronized (m$a.class) {
            if (lVar == null) {
                x.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
            } else {
                try {
                    fLm.remove(DownloadSettingTable$Columns.VALUE);
                    fLm.put(DownloadSettingTable$Columns.VALUE, str4);
                    fLm.remove("deviceId");
                    fLm.put("deviceId", str);
                    fLm.remove("serviceId");
                    fLm.put("serviceId", str2);
                    fLm.remove("characteristicId");
                    fLm.put("characteristicId", str3);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[]{e});
                }
                if (lVar == null) {
                    x.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                } else {
                    h a = fLl.a(lVar);
                    a.mData = fLm.toString();
                    a.ahM();
                    x.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", new Object[]{fLm.toString()});
                }
            }
        }
    }
}
