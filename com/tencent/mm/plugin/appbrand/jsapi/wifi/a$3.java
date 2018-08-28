package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class a$3 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ a gdp;

    a$3(a aVar, l lVar) {
        this.gdp = aVar;
        this.fCl = lVar;
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiConenctWifi", "remove listener");
        d.a(null);
        e.b(this.fCl.mAppId, this);
    }
}
