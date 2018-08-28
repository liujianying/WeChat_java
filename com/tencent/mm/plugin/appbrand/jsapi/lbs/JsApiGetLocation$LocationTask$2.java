package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;

class JsApiGetLocation$LocationTask$2 implements Runnable {
    final /* synthetic */ LocationTask fRn;

    JsApiGetLocation$LocationTask$2(LocationTask locationTask) {
        this.fRn = locationTask;
    }

    public final void run() {
        switch (LocationTask.c(this.fRn)) {
            case 1:
                LocationTask.d(this.fRn);
                return;
            case 2:
                LocationTask.aja();
                return;
            default:
                LocationTask.b(this.fRn, false);
                LocationTask.e(this.fRn);
                return;
        }
    }
}
