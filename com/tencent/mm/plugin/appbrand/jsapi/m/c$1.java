package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.bc.a$a;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements b {
    final /* synthetic */ c fYn;

    c$1(c cVar) {
        this.fYn = cVar;
    }

    public final void a(a$a a_a, a$a a_a2) {
        x.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + a_a.name() + "; newOrientation:" + a_a2.name());
        a.postDelayed(new 1(this, a_a2), 500);
    }
}
