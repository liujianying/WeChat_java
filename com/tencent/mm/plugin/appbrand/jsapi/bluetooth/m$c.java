package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class m$c extends h {
    private static final int CTRL_INDEX = 189;
    private static final String NAME = "onBluetoothAdapterStateChange";
    private static JSONObject fLm = new JSONObject();
    private static m$c fLo = new m$c();

    public static synchronized void a(l lVar, boolean z, boolean z2) {
        synchronized (m$c.class) {
            if (lVar == null) {
                x.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
            } else {
                try {
                    fLm.remove("available");
                    fLm.put("available", z);
                    fLm.remove("discovering");
                    fLm.put("discovering", z2);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[]{e});
                }
                if (lVar == null) {
                    x.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                } else {
                    h a = fLo.a(lVar);
                    a.mData = fLm.toString();
                    a.ahM();
                    x.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", new Object[]{fLm.toString()});
                }
            }
        }
    }
}
