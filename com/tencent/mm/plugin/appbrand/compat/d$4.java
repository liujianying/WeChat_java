package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class d$4 implements OnInfoWindowClickListener {
    final /* synthetic */ d fov;
    final /* synthetic */ j foy;

    d$4(d dVar, j jVar) {
        this.fov = dVar;
        this.foy = jVar;
    }

    public final void onInfoWindowClick(Marker marker) {
        if (this.foy != null) {
            this.foy.b(new g(marker));
        }
    }
}
