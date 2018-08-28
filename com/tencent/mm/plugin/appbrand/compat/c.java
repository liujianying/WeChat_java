package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;

final class c implements com.tencent.mm.plugin.appbrand.compat.a.b.c {
    final CircleOptions for = new CircleOptions();

    c() {
    }

    public final void f(double d, double d2) {
        this.for.center(new LatLng(d, d2));
    }

    public final void jO(int i) {
        this.for.radius((double) i);
    }

    public final void jP(int i) {
        this.for.strokeColor(i);
    }

    public final void jQ(int i) {
        this.for.strokeWidth((float) i);
    }

    public final void jR(int i) {
        this.for.fillColor(i);
    }
}
