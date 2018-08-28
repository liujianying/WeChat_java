package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.plugin.appbrand.compat.a.b$m;
import com.tencent.tencentmap.mapsdk.map.TencentMap$OnMapLoadedListener;

class d$1 implements TencentMap$OnMapLoadedListener {
    final /* synthetic */ b$m fou;
    final /* synthetic */ d fov;

    d$1(d dVar, b$m b_m) {
        this.fov = dVar;
        this.fou = b_m;
    }

    public final void onMapLoaded() {
        if (this.fou != null) {
            this.fou.onMapLoaded();
        }
    }
}
