package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.j.c;
import com.tencent.mm.plugin.appbrand.q.h;
import java.util.concurrent.CountDownLatch;

class m$2 implements c {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ m gfO;
    final /* synthetic */ h gfP;

    m$2(m mVar, h hVar, CountDownLatch countDownLatch) {
        this.gfO = mVar;
        this.gfP = hVar;
        this.dKv = countDownLatch;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.gfP.value = wxaPkgWrappingInfo;
        this.dKv.countDown();
    }
}
