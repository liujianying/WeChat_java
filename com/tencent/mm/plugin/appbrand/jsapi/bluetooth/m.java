package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m extends a {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";

    public final void a(final l lVar, JSONObject jSONObject, int i) {
        c.kB(0);
        x.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[]{lVar.mAppId});
        j a = a.a(r0, new 1(this, lVar), new h() {
            public final void W(String str, boolean z) {
                b.a(lVar, str, z);
            }
        }, new 3(this, lVar));
        Map hashMap = new HashMap();
        switch (a) {
            case OK:
                lVar.E(i, f("ok", null));
                c.kB(1);
                return;
            case BLE_SYSTEM_NOT_SUPPORT:
                hashMap.put("errCode", Integer.valueOf(10009));
                lVar.E(i, f("fail:system not support", hashMap));
                c.bK(2, 8);
                return;
            case BLE_NOT_AVAILABLE:
                lVar.E(i, f("fail:ble not available", null));
                c.bK(2, 7);
                return;
            default:
                lVar.E(i, f("fail", null));
                c.kB(2);
                return;
        }
    }
}
