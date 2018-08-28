package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.permission.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$c$1 implements Runnable {
    final /* synthetic */ c gqe;

    b$c$1(c cVar) {
        this.gqe = cVar;
    }

    public final void run() {
        Runnable runnable = (Runnable) b.amk().pollFirst();
        if (runnable != null) {
            runnable.run();
            return;
        }
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
        b.cZ(false);
    }
}
