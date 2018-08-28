package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements d {
    final /* synthetic */ c fSD;
    final /* synthetic */ i fSE;

    i$1(i iVar, c cVar) {
        this.fSE = iVar;
        this.fSD = cVar;
    }

    public final void agK() {
        x.i("MicroMsg.JsApiInsertMap", "onBackground");
        if (this.fSD != null) {
            this.fSD.cS(false);
        }
    }
}
