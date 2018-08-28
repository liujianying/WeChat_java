package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.jsapi.c.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ l fCl;
    b fQB = new b((byte) 0);
    c.a fQC = new c.a((byte) 0);
    final /* synthetic */ c fQD;

    c$1(c cVar, l lVar) {
        this.fQD = cVar;
        this.fCl = lVar;
    }

    public final void A(Map<String, JSONObject> map) {
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : map.values()) {
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("beacons", jSONArray);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[]{e});
        }
        h aC = this.fQB.aC(this.fCl.mAppId, this.fCl.hashCode());
        aC.mData = jSONObject2.toString();
        aC.ahM();
    }

    public final void cL(boolean z) {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[]{Boolean.valueOf(z)});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("available", z);
            jSONObject.put("discovering", false);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
        }
        x.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[]{jSONObject.toString()});
        h aC = this.fQC.aC(this.fCl.mAppId, this.fCl.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }
}
