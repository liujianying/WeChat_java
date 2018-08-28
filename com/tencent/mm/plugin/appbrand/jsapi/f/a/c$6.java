package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.compat.a.b$n;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f.a;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements b$n {
    final /* synthetic */ c fTi;

    c$6(c cVar) {
        this.fTi = cVar;
    }

    public final boolean c(h hVar) {
        e tF = this.fTi.tF((String) hVar.getTag());
        if (tF == null) {
            x.e("MicroMSg.AppBrandMapView", "[onMarkerClickListener] mapId:%d appbrandMarker is null, return", new Object[]{Integer.valueOf(this.fTi.mapId)});
            return false;
        } else if (this.fTi.fTd == null) {
            x.e("MicroMSg.AppBrandMapView", "[onMarkerClickListener] mapId:%d mapCalloutClick is null, return", new Object[]{Integer.valueOf(this.fTi.mapId)});
            return false;
        } else {
            if (tF.fTx != null) {
                x.e("MicroMSg.AppBrandMapView", "[onMarkerClickListener] mapId:%d mapCalloutClick is null, return", new Object[]{Integer.valueOf(this.fTi.mapId)});
                a aVar = tF.fTx.fTA;
                if (!(aVar == null || aVar.fTH != a.fTJ || hVar.isInfoWindowShown())) {
                    hVar.showInfoWindow();
                }
            }
            if (tF.fTv != null) {
                tF.fTv.set2Top();
            }
            if (tF.fTw != null) {
                tF.fTw.set2Top();
            }
            return this.fTi.fTd.b(tF);
        }
    }
}
