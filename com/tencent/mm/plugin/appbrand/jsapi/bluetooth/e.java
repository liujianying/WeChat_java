package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

@TargetApi(18)
public final class e extends a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        c.kB(116);
        x.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[]{lVar.mAppId});
        x.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[]{a.ts(r0)});
        switch (1.fLf[a.ts(r0).ordinal()]) {
            case 1:
                lVar.E(i, f("ok", null));
                c.kB(117);
                return;
            default:
                lVar.E(i, f("fail", null));
                c.kB(118);
                return;
        }
    }
}
