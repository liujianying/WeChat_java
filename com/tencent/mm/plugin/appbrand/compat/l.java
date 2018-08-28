package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mm.plugin.appbrand.compat.a.b$r;
import com.tencent.mm.plugin.appbrand.compat.a.b.g;

final class l implements b$r {
    final VisibleRegion foK;

    l(VisibleRegion visibleRegion) {
        this.foK = visibleRegion;
    }

    public final g adL() {
        return new e(this.foK.getLatLngBounds());
    }
}
