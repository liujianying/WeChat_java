package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.4;
import com.tencent.mm.sdk.platformtools.x;

class c$4$2 extends b {
    final /* synthetic */ 4 fPA;

    c$4$2(4 4) {
        this.fPA = 4;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiEnterContact", "onDestroy");
        if (c.fIS > 0) {
            c.fIS--;
            this.fPA.fIY.fdO.aav();
        }
        this.fPA.fPy.ahB();
        e.b(this.fPA.fIY.mAppId, this);
    }
}
