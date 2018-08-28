package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.sdk.platformtools.x;

class r$2 implements a {
    final /* synthetic */ String ewx;

    r$2(String str) {
        this.ewx = str;
    }

    public final void qe(String str) {
        x.i("MicroMsg.SourceMapInjector", "Inject '%s' Script Success: %s", new Object[]{this.ewx, str});
    }

    public final void fM(String str) {
        x.e("MicroMsg.SourceMapInjector", "Inject '%s' Script Failed: %s", new Object[]{this.ewx, str});
    }
}
