package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.pluginsdk.model.app.g.a;

class JsApiLaunchApplication$a implements a {
    volatile boolean bSi;
    volatile boolean dJP;
    volatile boolean fGh;
    volatile boolean fGi;
    a fGj;

    JsApiLaunchApplication$a(a aVar) {
        this.fGj = aVar;
    }

    public final void cI(boolean z) {
        this.dJP = true;
        this.fGh = z;
        if (this.fGi && this.fGj != null) {
            this.fGj.r(this.bSi, z);
        }
    }

    final void cJ(boolean z) {
        this.bSi = z;
        this.fGi = true;
        if (this.dJP && this.fGj != null) {
            this.fGj.r(z, this.fGh);
        }
    }
}
