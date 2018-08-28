package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class z$2 implements Runnable {
    final /* synthetic */ z pMa;

    z$2(z zVar) {
        this.pMa = zVar;
    }

    public final void run() {
        a aVar = b.dnp;
        c fJ = a.fJ("100344");
        if (fJ == null) {
            x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
            return;
        }
        z zVar = this.pMa;
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpen"));
        z.a(zVar, z);
        x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload :%b", new Object[]{Boolean.valueOf(z.b(this.pMa))});
        aVar = b.dnp;
        fJ = a.fJ("100346");
        if (fJ == null) {
            x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
            return;
        }
        zVar = this.pMa;
        if (fJ.isValid() && "1".equals(fJ.ckq().get("isOpen"))) {
            z = true;
        } else {
            z = false;
        }
        z.b(zVar, z);
        x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openRecommendPreload :%b", new Object[]{Boolean.valueOf(z.c(this.pMa))});
    }
}
