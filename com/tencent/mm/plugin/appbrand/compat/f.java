package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;

final class f implements com.tencent.mm.plugin.appbrand.compat.a.b.f {
    final LatLng foC;

    public final double adG() {
        return this.foC.getLatitude();
    }

    public final double adH() {
        return this.foC.getLongitude();
    }

    f(double d, double d2) {
        this.foC = new LatLng(d, d2);
    }

    f(LatLng latLng) {
        if (latLng != null) {
            this.foC = latLng;
        } else {
            this.foC = new LatLng(0.0d, 0.0d);
        }
    }

    static LatLng a(com.tencent.mm.plugin.appbrand.compat.a.b.f fVar) {
        if (fVar instanceof f) {
            return ((f) fVar).foC;
        }
        return new LatLng(fVar.adG(), fVar.adH());
    }
}
