package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class j extends a {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        List list = null;
        c.kB(166);
        String str = lVar.mAppId;
        String str2 = "MicroMsg.JsApiGetBluetoothDevices";
        String str3 = "appId:%s getBluetoothDevices data:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (jSONObject == null) {
            jSONObject = "";
        }
        objArr[1] = jSONObject;
        x.i(str2, str3, objArr);
        b tr = a.tr(str);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(168, 170);
        } else if (b.aiB()) {
            if (tr.fLc != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = tr.fLc;
                if (bVar.fLI != null) {
                    list = new ArrayList(bVar.fLI.fMP.values());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                list.addAll(tr.air());
                for (d ahS : list) {
                    try {
                        jSONArray.put(ahS.ahS());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", e, "", new Object[0]);
                    }
                }
            }
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("devices", jSONArray);
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[]{Log.getStackTraceString(e2)});
            }
            x.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[]{jSONObject2});
            lVar.E(i, jSONObject2.toString());
            c.kB(167);
        } else {
            x.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(168, 172);
        }
    }
}
