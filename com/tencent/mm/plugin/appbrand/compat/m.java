package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mm.plugin.appbrand.compat.a.b.d;

abstract class m<T extends IOverlay> implements d {
    final T foL;

    m(T t) {
        this.foL = t;
    }

    public final void remove() {
        if (this.foL != null) {
            this.foL.remove();
        }
    }
}
