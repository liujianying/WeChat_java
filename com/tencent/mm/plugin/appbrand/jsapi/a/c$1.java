package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends b {
    final /* synthetic */ p fJO;
    final /* synthetic */ c fKg;

    c$1(c cVar, p pVar) {
        this.fKg = cVar;
        this.fJO = pVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "AppBrandLifeCycle onDestroy");
        e.b(this.fJO.mAppId, this);
        this.fKg.aih();
    }
}
