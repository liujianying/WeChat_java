package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        a.a tz = a.tz(lVar.mAppId);
        Map hashMap;
        if (tz == null) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            lVar.E(i, f("fail", hashMap));
            return;
        }
        if (tz.wk()) {
            a.remove(lVar.mAppId);
            new HashMap().put("errCode", Integer.valueOf(0));
            lVar.E(i, f("ok", null));
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            lVar.E(i, f("fail", hashMap));
        }
        a aVar = new a((byte) 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", a.fLa);
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
        }
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[]{jSONObject2.toString()});
        h aC = aVar.aC(lVar.mAppId, lVar.hashCode());
        aC.mData = jSONObject2.toString();
        aC.ahM();
    }
}
