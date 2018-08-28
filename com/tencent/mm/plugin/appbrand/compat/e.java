package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;
import com.tencent.mm.plugin.appbrand.compat.a.b.g;

final class e implements g {
    final LatLngBounds foB;

    e(LatLngBounds latLngBounds) {
        this.foB = latLngBounds;
    }

    public final b$f adE() {
        LatLng southwest = this.foB.getSouthwest();
        return new f(southwest.getLatitude(), southwest.getLongitude());
    }

    public final b$f adF() {
        LatLng northeast = this.foB.getNortheast();
        return new f(northeast.getLatitude(), northeast.getLongitude());
    }
}
