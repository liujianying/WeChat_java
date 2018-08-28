package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class g$15 implements b {
    final /* synthetic */ long dUQ;
    final /* synthetic */ g fdd;

    g$15(g gVar, long j) {
        this.fdd = gVar;
        this.dUQ = j;
    }

    public final void b(AppBrandSysConfig appBrandSysConfig) {
        x.i("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask.onPrepareDone");
        if (!this.fdd.fcq.isFinishing()) {
            if (appBrandSysConfig == null) {
                this.fdd.finish();
                return;
            }
            ah.A(new 1(this));
            this.fdd.fcJ.o(1, System.currentTimeMillis() - this.dUQ);
            a.a(this.fdd.mAppId, "ResourcePrepare", this.dUQ, System.currentTimeMillis());
            this.fdd.fcu = appBrandSysConfig;
            this.fdd.fcv = com.tencent.mm.plugin.appbrand.config.a.o(this.fdd);
            this.fdd.fcw = com.tencent.mm.plugin.appbrand.jsapi.file.a.s(this.fdd);
            x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. app-config parsed.");
            this.fdd.fcq.runOnUiThread(new 2(this));
        }
    }

    public final void onDownloadStarted() {
        this.fdd.fcY = true;
        if (this.fdd.fcZ != null) {
            this.fdd.fcZ.gsk = true;
        }
    }

    public final void jz(int i) {
        x.i("MicroMsg.AppBrandRuntime", "onDownloadProgress %d", new Object[]{Integer.valueOf(i)});
        ah.A(new 3(this, i));
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
        g gVar = this.fdd;
        4 4 = new 4(this, aVar);
        if (gVar.dti) {
            gVar.fcq.runOnUiThread(4);
        } else {
            gVar.fcx.offerLast(4);
        }
    }
}
