package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] fLf = new int[j.values().length];

        static {
            try {
                fLf[j.fMv.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        c.kB(91);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            lVar.E(i, f("fail:invalid data", null));
            c.bK(93, 94);
            return;
        }
        x.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s createBLEConnection data %s", new Object[]{lVar.mAppId, jSONObject.toString()});
        b tr = a.tr(lVar.mAppId);
        Map hashMap;
        if (tr == null) {
            x.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(93, 96);
        } else if (b.aiB()) {
            String optString = jSONObject.optString("deviceId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a.a();
            aVar.Zq = optBoolean;
            aVar.fLy = optBoolean2;
            aVar.fLA = optBoolean3;
            tr.a(optString, aVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b() {
                public final void a(j jVar) {
                    Map hashMap;
                    switch (AnonymousClass2.fLf[jVar.ordinal()]) {
                        case 1:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            lVar.E(i, d.this.f("ok", hashMap));
                            c.kB(92);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            lVar.E(i, d.this.f(jVar.Yy, hashMap));
                            c.kB(93);
                            return;
                    }
                }
            });
        } else {
            x.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(93, 98);
        }
    }
}
