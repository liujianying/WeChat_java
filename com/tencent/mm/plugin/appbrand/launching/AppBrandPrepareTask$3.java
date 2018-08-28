package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;

class AppBrandPrepareTask$3 implements Runnable {
    final /* synthetic */ AppBrandPrepareTask geW;

    AppBrandPrepareTask$3(AppBrandPrepareTask appBrandPrepareTask) {
        this.geW = appBrandPrepareTask;
    }

    public final void run() {
        int i = 369;
        if (this.geW.geV) {
            i = 777;
        }
        h.mEJ.a((long) i, 3, 1, false);
        a.a(this.geW.geS.mAppId, 0, this.geW.geS.gfg, i, 3);
    }
}
