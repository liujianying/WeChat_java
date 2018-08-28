package com.tencent.mm.plugin.appbrand.compat;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

class d$6 implements InfoWindowAdapter {
    final /* synthetic */ e foA;
    final /* synthetic */ d fov;

    d$6(d dVar, e eVar) {
        this.fov = dVar;
        this.foA = eVar;
    }

    public final View getInfoWindow(Marker marker) {
        return this.foA.a(new g(marker));
    }

    public final void onInfoWindowDettached(Marker marker, View view) {
        e eVar = this.foA;
        g gVar = new g(marker);
        eVar.bG(view);
    }
}
