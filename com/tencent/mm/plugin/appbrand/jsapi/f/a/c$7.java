package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f.a;

class c$7 implements l {
    final /* synthetic */ c fTi;

    c$7(c cVar) {
        this.fTi = cVar;
    }

    public final void adO() {
        for (e eVar : this.fTi.fTa.values()) {
            if (eVar.fTx != null && eVar.fTx.fTA != null && eVar.fTx.fTA.fTH == a.fTJ && eVar.fTv.isInfoWindowShown()) {
                eVar.fTv.hideInfoWindow();
            }
        }
        if (this.fTi.fSZ != null) {
            this.fTi.fSZ.ajg();
        }
    }
}
