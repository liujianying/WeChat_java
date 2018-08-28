package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.j.c;
import com.tencent.mm.plugin.appbrand.q.h;
import java.util.concurrent.CountDownLatch;

class m$1 implements c {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ h gfN;
    final /* synthetic */ m gfO;

    m$1(m mVar, h hVar, CountDownLatch countDownLatch) {
        this.gfO = mVar;
        this.gfN = hVar;
        this.dKv = countDownLatch;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.gfN.value = wxaPkgWrappingInfo;
        this.dKv.countDown();
    }
}
