package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements e {
    final /* synthetic */ String bAj;
    final /* synthetic */ p fIY;
    final /* synthetic */ i fSE;
    final /* synthetic */ int fSF;

    i$3(i iVar, p pVar, String str, int i) {
        this.fSE = iVar;
        this.fIY = pVar;
        this.bAj = str;
        this.fSF = i;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiInsertMap", "onDestroy");
        this.fIY.b(this);
        b.F(this.bAj, this.fIY.hashCode(), this.fSF);
    }
}
