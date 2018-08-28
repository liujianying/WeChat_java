package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        super.a(lVar, jSONObject, i);
        Map hashMap;
        if (!d.gdr) {
            x.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            lVar.E(i, f("fail:not invoke startWifi", hashMap));
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            lVar.E(i, f("fail:invalid data", hashMap));
        } else {
            Context context = lVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                lVar.E(i, f("fail:context is null", hashMap));
                return;
            }
            d.cC(context);
            if (c.isWifiEnabled()) {
                final com.tencent.mm.plugin.appbrand.widget.c.d dVar = new com.tencent.mm.plugin.appbrand.widget.c.d(context);
                dVar.setCancelable(false);
                ah.A(new Runnable() {
                    public final void run() {
                        lVar.fdO.a(dVar);
                    }
                });
                d.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a() {
                    public final void uh(String str) {
                        d.a(null);
                        ah.A(new Runnable() {
                            public final void run() {
                                if (dVar != null) {
                                    dVar.dismiss();
                                }
                            }
                        });
                        if (str.equals("ok")) {
                            b akv = d.akv();
                            x.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[]{akv});
                            Map hashMap;
                            if (akv == null) {
                                x.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(0));
                                lVar.E(i, a.this.f("ok:can't gain current wifi may be not open GPS", hashMap));
                                return;
                            }
                            try {
                                Map hashMap2 = new HashMap();
                                hashMap2.put(TencentExtraKeys.LOCATION_SOURCE_WIFI, akv.tR());
                                hashMap2.put("errCode", Integer.valueOf(0));
                                lVar.E(i, a.this.f("ok", hashMap2));
                                return;
                            } catch (Throwable e) {
                                x.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
                                x.printErrStackTrace("MicroMsg.JsApiConenctWifi", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                lVar.E(i, a.this.f("fail:parse json err", hashMap));
                                return;
                            }
                        }
                        HashMap hashMap3 = new HashMap();
                        if (str.equals("duplicated request")) {
                            hashMap3.put("errCode", Integer.valueOf(12004));
                        } else if (str.equals("password error")) {
                            hashMap3.put("errCode", Integer.valueOf(12002));
                        } else {
                            hashMap3.put("errCode", Integer.valueOf(12003));
                        }
                        x.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", new Object[]{str});
                        lVar.E(i, a.this.f("fail:" + str, hashMap3));
                    }
                });
                e.a(lVar.mAppId, new 3(this, lVar));
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(12008));
                    lVar.E(i, f("fail:invalid data", hashMap));
                    return;
                }
                x.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[]{optString, optString2});
                d.F(optString, optString2, optString3);
                return;
            }
            x.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12005));
            lVar.E(i, f("fail:wifi is disable", hashMap));
        }
    }
}
