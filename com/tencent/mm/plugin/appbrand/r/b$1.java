package com.tencent.mm.plugin.appbrand.r;

import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b gBv;

    b$1(b bVar) {
        this.gBv = bVar;
    }

    public final void aou() {
        x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        m.tm(this.gBv.appId);
    }
}
