package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Map hashMap;
        if (d.gdr) {
            Context context = lVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                lVar.E(i, f("fail:context is null", hashMap));
                return;
            }
            d.cC(context);
            if (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c akw = d.akw();
                if (akw.fHW.equals("ok")) {
                    try {
                        x.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", new Object[]{Integer.valueOf(akw.gdB.size())});
                        if (akw.gdB.size() == 0) {
                            if (VERSION.SDK_INT < 23 || j.Ae() || ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
                                x.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                                if (!com.tencent.mm.pluginsdk.permission.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                                    hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(12012));
                                    lVar.E(i, f("fail:may be not obtain GPS Perrmission", hashMap));
                                    x.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                                    return;
                                }
                            }
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(12006));
                            lVar.E(i, f("fail:may be not open GPS", hashMap));
                            x.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                            return;
                        }
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(0));
                        lVar.E(i, f("ok", hashMap));
                        x.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", new Object[]{akw});
                        a aVar = new a();
                        Map hashMap2 = new HashMap();
                        hashMap2.put("wifiList", akw.aku());
                        aVar.aC(lVar.mAppId, 0).x(hashMap2).ahM();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiGetWifiList", e, "", new Object[0]);
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        lVar.E(i, f("fail:parse json err", hashMap));
                        return;
                    }
                }
                x.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", new Object[]{akw.fHW});
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                lVar.E(i, f("fail:" + akw.fHW, hashMap));
                return;
            }
            x.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12005));
            lVar.E(i, f("fail:wifi is disable", hashMap));
            return;
        }
        x.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        lVar.E(i, f("fail:not invoke startWifi", hashMap));
    }
}
