package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class m$b extends h {
    private static final int CTRL_INDEX = 188;
    private static final String NAME = "onBLEConnectionStateChanged";
    private static JSONObject fLm = new JSONObject();
    private static m$b fLn = new m$b();

    private m$b() {
    }

    public static synchronized void a(l lVar, String str, boolean z) {
        synchronized (m$b.class) {
            if (lVar == null) {
                x.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
            } else {
                try {
                    fLm.remove("deviceId");
                    fLm.put("deviceId", str);
                    fLm.remove("connected");
                    fLm.put("connected", z);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[]{e});
                }
                if (lVar == null) {
                    x.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                } else {
                    h a = fLn.a(lVar);
                    a.mData = fLm.toString();
                    a.ahM();
                    x.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", new Object[]{fLm.toString()});
                }
            }
        }
    }
}
