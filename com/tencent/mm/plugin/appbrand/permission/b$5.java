package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.sdk.platformtools.x;

class b$5 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ String fEQ;
    final /* synthetic */ Runnable gqb;

    b$5(Runnable runnable, String str, String str2) {
        this.gqb = runnable;
        this.bAj = str;
        this.fEQ = str2;
    }

    public final void run() {
        if (b.uB()) {
            b.amk().add(this.gqb);
            x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[]{this.bAj, this.fEQ});
            return;
        }
        b.cZ(true);
        this.gqb.run();
    }
}
