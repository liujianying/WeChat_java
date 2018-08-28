package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.by.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public enum i {
    ;
    
    public volatile boolean fiR;
    public volatile f<Void> fiS;

    private i(String str) {
        this.fiR = false;
    }

    public final synchronized void acr() {
        if (this.fiR) {
            x.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
        } else if (g.Eg().dpD) {
            x.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
            this.fiR = true;
            this.fiS = com.tencent.mm.by.g.cDZ();
            this.fiS.j(new 1(this));
        } else {
            x.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
        }
    }
}
