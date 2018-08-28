package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.concurrent.CountDownLatch;

class ah$a$1 implements a {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ String fhh;
    final /* synthetic */ s.a fhi;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.base.a fhj;
    final /* synthetic */ h fhk;
    final /* synthetic */ ah.a fhl;

    ah$a$1(ah.a aVar, String str, s.a aVar2, com.tencent.mm.plugin.appbrand.appcache.base.a aVar3, h hVar, CountDownLatch countDownLatch) {
        this.fhl = aVar;
        this.fhh = str;
        this.fhi = aVar2;
        this.fhj = aVar3;
        this.fhk = hVar;
        this.dKv = countDownLatch;
    }

    public final boolean vD() {
        g.ND().lx(this.fhh);
        this.fhi.abt();
        e.deleteFile(this.fhj.getFilePath());
        this.fhk.value = null;
        this.dKv.countDown();
        return false;
    }
}
