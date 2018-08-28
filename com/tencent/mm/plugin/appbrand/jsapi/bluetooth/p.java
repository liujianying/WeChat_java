package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(i$l.AppCompatTheme_buttonStyleSmall);
        String str = lVar.mAppId;
        String str2 = "MicroMsg.JsApiStopBluetoothDevicesDiscovery";
        String str3 = "appId:%s stopBluetoothDevicesDiscovery data:%s";
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
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            lVar.E(i, f("fail:not init", hashMap));
            c.bK(i$l.AppCompatTheme_checkedTextViewStyle, i$l.AppCompatTheme_ratingBarStyle);
        } else if (b.aiB()) {
            j aiw;
            if (tr.fLc != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = tr.fLc;
                aiw = bVar.fLI != null ? bVar.fLI.aiw() : j.fMw;
            } else {
                aiw = j.fMw;
            }
            x.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", new Object[]{aiw});
            Map hashMap2 = new HashMap();
            switch (1.fLf[aiw.ordinal()]) {
                case 1:
                    hashMap2.put("isDiscovering", Boolean.valueOf(false));
                    lVar.E(i, f("ok", hashMap2));
                    c.kB(i$l.AppCompatTheme_checkboxStyle);
                    c.a(lVar, true, false);
                    return;
                default:
                    hashMap2.put("isDiscovering", Boolean.valueOf(false));
                    lVar.E(i, f("fail", hashMap2));
                    c.kB(i$l.AppCompatTheme_checkedTextViewStyle);
                    return;
            }
        } else {
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            lVar.E(i, f("fail:not available", hashMap));
            c.bK(i$l.AppCompatTheme_checkedTextViewStyle, i$l.AppCompatTheme_ratingBarStyleSmall);
        }
    }
}
