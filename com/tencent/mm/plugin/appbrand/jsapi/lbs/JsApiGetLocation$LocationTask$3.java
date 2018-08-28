package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetLocation$LocationTask$3 implements a {
    final /* synthetic */ LocationTask fRn;

    JsApiGetLocation$LocationTask$3(LocationTask locationTask) {
        this.fRn = locationTask;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        x.v("MicroMsg.JsApiGetLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f, altitude : %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)});
        LocationTask.b(this.fRn, true);
        LocationTask.a(this.fRn, f2);
        LocationTask.b(this.fRn, f);
        LocationTask locationTask = this.fRn;
        if (d == 0.0d) {
            d = -1.0d;
        }
        LocationTask.a(locationTask, d);
        LocationTask.b(this.fRn, d2);
        LocationTask.c(this.fRn, d3);
        LocationTask.f(this.fRn);
        LocationTask.d(this.fRn, d2);
        LocationTask.b(this.fRn, i);
        if (d3 == 0.0d && LocationTask.g(this.fRn)) {
            g.Em().h(new 1(this), 5000);
            x.i("MicroMsg.JsApiGetLocation", "post delay 5 sec.");
        } else {
            x.i("MicroMsg.JsApiGetLocation", "Stop callback");
            LocationTask.h(this.fRn);
            LocationTask.i(this.fRn);
        }
        return false;
    }
}
