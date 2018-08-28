package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 315;
    public static final String NAME = "stopWifi";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
        Context context = lVar.getContext();
        Map hashMap;
        if (context == null) {
            x.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            lVar.E(i, f("fail:context is null", hashMap));
        } else if (d.gdr) {
            if (d.gds != null) {
                x.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
                context.unregisterReceiver(d.gds);
                d.gdr = false;
                d.gds = null;
            }
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            lVar.E(i, f("ok", hashMap));
        } else {
            x.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            lVar.E(i, f("fail:not invoke startWifi", hashMap));
        }
    }
}
