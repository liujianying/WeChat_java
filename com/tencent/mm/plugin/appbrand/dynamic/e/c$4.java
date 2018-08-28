package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.plugin.appbrand.dynamic.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView.c;

class c$4 implements c {
    c$4() {
    }

    public final void onCoreInitFinished() {
        x.i("MicroMsg.JSEngineInitializer", "onCoreInitFinished");
        c.Ju();
        for (a aaS : c.afl()) {
            aaS.aaS();
        }
    }

    public final void uL() {
        x.i("MicroMsg.JSEngineInitializer", "onCoreInitFailed");
    }
}
