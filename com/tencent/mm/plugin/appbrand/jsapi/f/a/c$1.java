package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements j {
    final /* synthetic */ c fTi;

    c$1(c cVar) {
        this.fTi = cVar;
    }

    public final void b(h hVar) {
        e tF = this.fTi.tF((String) hVar.getTag());
        if (tF == null) {
            x.e("MicroMSg.AppBrandMapView", "[onInfoWindowClick] mapId:%d appbrandMarker is null, return", new Object[]{Integer.valueOf(this.fTi.mapId)});
        } else if (this.fTi.fTc == null) {
            x.e("MicroMSg.AppBrandMapView", "[onInfoWindowClick] mapId:%d mapCalloutClick is null, return", new Object[]{Integer.valueOf(this.fTi.mapId)});
        } else {
            this.fTi.fTc.a(tF);
        }
    }
}
