package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;

class k$1 implements b$f {
    final /* synthetic */ LatLng foI;

    k$1(LatLng latLng) {
        this.foI = latLng;
    }

    public final double adG() {
        return this.foI.getLatitude();
    }

    public final double adH() {
        return this.foI.getLongitude();
    }

    public final String toString() {
        return "lat/lng: (" + this.foI.getLatitude() + "," + this.foI.getLongitude() + ")";
    }
}
