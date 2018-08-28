package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fHv;

    b$2(b bVar, l lVar) {
        this.fHv = bVar;
        this.fCl = lVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        if (aVar == com.tencent.mm.plugin.appbrand.b.a.fjh) {
            x.d("MicroMsg.DownloadAppStateChangeEvent", "destroyed");
            MMToClientEvent.b(b.a(this.fHv));
            b.g(this.fCl);
        }
    }
}
