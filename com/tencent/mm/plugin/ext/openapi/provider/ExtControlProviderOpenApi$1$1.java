package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.g.a.ez;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$1$1 implements Runnable {
    final /* synthetic */ ez iJH;
    final /* synthetic */ 1 iJI;

    ExtControlProviderOpenApi$1$1(1 1, ez ezVar) {
        this.iJI = 1;
        this.iJH = ezVar;
    }

    public final void run() {
        x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
        if (this.iJH != null && this.iJH.bNa != null && this.iJH.bNa.bMG != 0) {
            x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
            this.iJI.cf(this.iJH.bNa.bNc);
        }
    }
}
