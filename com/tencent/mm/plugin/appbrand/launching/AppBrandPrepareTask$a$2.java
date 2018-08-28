package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$a$2 implements g {
    final /* synthetic */ c geY;
    final /* synthetic */ a gfa;
    final /* synthetic */ d gfc;

    AppBrandPrepareTask$a$2(a aVar, c cVar, d dVar) {
        this.gfa = aVar;
        this.geY = cVar;
        this.gfc = dVar;
    }

    public final void vk() {
        com.tencent.mm.kernel.g.Eg();
        boolean Dw = com.tencent.mm.kernel.a.Dw();
        boolean Dr = com.tencent.mm.kernel.a.Dr();
        if (!Dw || Dr) {
            x.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", new Object[]{Boolean.valueOf(Dw), Boolean.valueOf(Dr)});
            ah.A(new 1(this));
            if (this.geY != null) {
                PrepareResult prepareResult = new PrepareResult();
                PrepareResult.a(prepareResult, 3);
                this.geY.at(prepareResult);
                return;
            }
            return;
        }
        2 2 = new 2(this);
        if (com.tencent.mm.kernel.g.Eg().dpD) {
            2.a(null);
            return;
        }
        x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
        2.cht();
    }

    public final void aF(boolean z) {
    }
}
