package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.launching.y.b;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class y$a implements Callable<WxaPkgWrappingInfo> {
    private final int ggp;
    private final int ggq;
    private final akm ggr;
    final /* synthetic */ y ggs;

    /* synthetic */ y$a(y yVar, int i, int i2, akm akm, byte b) {
        this(yVar, i, i2, akm);
    }

    public final /* synthetic */ Object call() {
        return (bi.oW(this.ggr.bRK) || !k.abE()) ? new b(this.ggs, this.ggq, (byte) 0).afp() : akK();
    }

    private y$a(y yVar, int i, int i2, akm akm) {
        this.ggs = yVar;
        this.ggp = i;
        this.ggq = i2;
        this.ggr = akm;
    }

    private WxaPkgWrappingInfo akK() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        h hVar = new h();
        if (!i.a(this.ggs.appId, this.ggp, this.ggq, this.ggr.bRK, new 1(this, this.ggs.fmv, hVar, countDownLatch))) {
            return null;
        }
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadIncremental semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) hVar.value;
    }
}
