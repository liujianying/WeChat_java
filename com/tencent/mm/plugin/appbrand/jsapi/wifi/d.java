package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 314;
    public static final String NAME = "startWifi";
    public static boolean gdr = false;
    public static BroadcastReceiver gds = null;

    static /* synthetic */ void m(l lVar) {
        try {
            a.a aVar = new a.a();
            Map hashMap = new HashMap();
            hashMap.put("wifi", new b().tR());
            aVar.aC(lVar.mAppId, 0).x(hashMap).ahM();
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
            x.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
        }
    }

    public final void a(final l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
        final Context context = lVar.getContext();
        Map hashMap;
        if (context == null) {
            x.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            lVar.E(i, f("fail:context is null", hashMap));
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cC(context);
        if (!gdr) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            gds = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        CharSequence action = intent.getAction();
                        if (!TextUtils.isEmpty(action)) {
                            int intExtra;
                            x.i("MicroMsg.JsApiStartWifi", "actiong:%s", new Object[]{action});
                            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                                intExtra = intent.getIntExtra("wifi_state", 0);
                                x.i("MicroMsg.JsApiStartWifi", "wifiState" + intExtra);
                                switch (intExtra) {
                                    case 1:
                                        d.m(lVar);
                                        break;
                                }
                            }
                            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                                if (parcelableExtra != null) {
                                    NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                                    intExtra = networkInfo.getState() == State.CONNECTED ? 1 : 0;
                                    int i;
                                    if (networkInfo.getType() == 1) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (intExtra == 0 || i == 0) {
                                        d.m(lVar);
                                        return;
                                    }
                                    b akv = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.akv();
                                    x.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", new Object[]{akv});
                                    if (akv == null) {
                                        x.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                                        return;
                                    }
                                    try {
                                        a.a aVar = new a.a();
                                        Map hashMap = new HashMap();
                                        hashMap.put("wifi", akv.tR());
                                        aVar.aC(lVar.mAppId, 0).x(hashMap).ahM();
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                                        x.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                    }
                }
            };
            context.registerReceiver(gds, intentFilter);
            gdr = true;
        }
        e.a(lVar.mAppId, new e.b() {
            public final void onDestroy() {
                if (d.gds != null) {
                    x.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
                    context.unregisterReceiver(d.gds);
                    d.gdr = false;
                    d.gds = null;
                }
                e.b(lVar.mAppId, this);
            }
        });
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(0));
        lVar.E(i, f("ok", hashMap));
    }
}
