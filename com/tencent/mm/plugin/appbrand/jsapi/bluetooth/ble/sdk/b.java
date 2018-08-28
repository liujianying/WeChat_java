package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.a;

public final class b {
    private Context context;
    public c fLH;
    public a fLI;

    public b(Context context) {
        this.context = context;
        this.fLH = new c(context);
        this.fLI = new a(context);
    }
}
