package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.view.View;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f.a;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.sdk.platformtools.x;

public class c$g implements e {
    final /* synthetic */ c fTi;

    public c$g(c cVar) {
        this.fTi = cVar;
    }

    public final View a(h hVar) {
        c.e tF = this.fTi.tF((String) hVar.getTag());
        if (tF == null) {
            x.e("MicroMSg.AppBrandMapView", "[getInfoWindow] appbrandMarker is null, return");
            return null;
        } else if (tF.fTx == null) {
            x.e("MicroMSg.AppBrandMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
            return null;
        } else {
            a aVar = tF.fTx.fTA;
            if (aVar == null || aVar.fTH == a.fTK) {
                return null;
            }
            return this.fTi.a(aVar);
        }
    }

    public final void bG(View view) {
        if (view instanceof c) {
            x.d("MicroMSg.AppBrandMapView", "recycler calloutView");
            a.a((c) view);
        }
    }
}
