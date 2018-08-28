package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.y.a;
import com.tencent.mm.plugin.appbrand.q.h;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

class y$a$1 extends n {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ h fxa;
    final /* synthetic */ a ggt;

    y$a$1(a aVar, int i, h hVar, CountDownLatch countDownLatch) {
        this.ggt = aVar;
        this.fxa = hVar;
        this.dKv = countDownLatch;
        super(i);
    }

    final String akG() {
        return String.format(Locale.US, "Incremental %d|%d", new Object[]{Integer.valueOf(a.a(this.ggt)), Integer.valueOf(a.b(this.ggt))});
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.fxa.value = wxaPkgWrappingInfo;
        this.dKv.countDown();
    }
}
