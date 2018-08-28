package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.plugin.appbrand.compat.a.b$q;
import com.tencent.mm.plugin.appbrand.compat.a.b$r;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.tencentmap.mapsdk.map.Projection;

final class j implements b$q {
    final Projection foH;

    j(Projection projection) {
        this.foH = projection;
    }

    public final b$r adK() {
        return new l(this.foH.getVisibleRegion());
    }

    public final double a(f fVar, f fVar2) {
        return this.foH.distanceBetween(f.a(fVar), f.a(fVar2));
    }
}
