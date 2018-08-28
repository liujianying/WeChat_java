package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$1$1$1 implements JsApiLaunchApplication$a$a {
    final /* synthetic */ 1 fGa;

    JsApiLaunchApplication$1$1$1(1 1) {
        this.fGa = 1;
    }

    public final void r(boolean z, boolean z2) {
        x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.fGa.fFZ.fCl.E(this.fGa.fFZ.doP, this.fGa.fFZ.fFY.f("ok", null));
        } else {
            this.fGa.fFZ.fCl.E(this.fGa.fFZ.doP, this.fGa.fFZ.fFY.f("fail:scheme launch fail", null));
        }
    }
}
