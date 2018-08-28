package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.k.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.TimerTask;

class j$2 extends TimerTask {
    final /* synthetic */ a glq;
    final /* synthetic */ j glr;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.s.a.a gls;
    final /* synthetic */ Timer glt;

    j$2(j jVar, a aVar, com.tencent.mm.plugin.appbrand.s.a.a aVar2, Timer timer) {
        this.glr = jVar;
        this.glq = aVar;
        this.gls = aVar2;
        this.glt = timer;
    }

    public final void run() {
        x.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
        this.glq.sl("connect response time out");
        this.gls.close();
        this.glr.b(this.gls);
        cancel();
        this.glt.cancel();
    }
}
