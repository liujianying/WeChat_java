package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetLocation$LocationTask$4 implements Runnable {
    final /* synthetic */ LocationTask fRn;

    JsApiGetLocation$LocationTask$4(LocationTask locationTask) {
        this.fRn = locationTask;
    }

    public final void run() {
        x.i("MicroMsg.JsApiGetLocation", "Timeout, callback running? %b", new Object[]{Boolean.valueOf(LocationTask.k(this.fRn))});
        if (LocationTask.k(this.fRn)) {
            LocationTask.h(this.fRn);
            LocationTask.b(this.fRn, false);
            LocationTask.l(this.fRn);
        }
    }
}
