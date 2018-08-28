package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.sdk.platformtools.x;

class c$10 implements OnClickListener {
    final /* synthetic */ c fTi;
    final /* synthetic */ String fTp;

    public c$10(c cVar, String str) {
        this.fTi = cVar;
        this.fTp = str;
    }

    public final void onClick(View view) {
        if (this.fTi.fTc == null) {
            x.e("MicroMSg.AppBrandMapView", "[onInfoWindowClick] mapCalloutClick is null, return");
            return;
        }
        e tF = this.fTi.tF(this.fTp);
        if (tF == null) {
            x.e("MicroMSg.AppBrandMapView", "[onInfoWindowClick] appbrandMarker is null, return");
        } else {
            this.fTi.fTc.a(tF);
        }
    }
}
