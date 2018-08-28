package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;

class JsApiGetLocation$LocationTask$1 implements Runnable {
    final /* synthetic */ LocationTask fRn;

    JsApiGetLocation$LocationTask$1(LocationTask locationTask) {
        this.fRn = locationTask;
    }

    public final void run() {
        LocationTask.b(this.fRn);
    }
}
