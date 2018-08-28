package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class y$b implements Callable<WxaPkgWrappingInfo> {
    final /* synthetic */ y ggs;
    private final int ggu;

    /* synthetic */ y$b(y yVar, int i, byte b) {
        this(yVar, i);
    }

    private y$b(y yVar, int i) {
        this.ggs = yVar;
        this.ggu = i;
    }

    /* renamed from: afp */
    public final WxaPkgWrappingInfo call() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        h hVar = new h();
        1 1 = new 1(this, this.ggs.fmv, hVar, countDownLatch);
        x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[]{this.ggs.appId, Integer.valueOf(this.ggs.fmv), Integer.valueOf(this.ggu)});
        if (this.ggs.fmv != 0) {
            this.ggs.fwZ = e.abi().ai(this.ggs.appId, this.ggs.fmv);
            if (bi.oW(this.ggs.fwZ)) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d)", new Object[]{this.ggs.appId, Integer.valueOf(this.ggs.fmv)});
                this.ggs.a(a.fhC);
                return null;
            }
        }
        if (aq.a(this.ggs.appId, this.ggs.fmv, this.ggu, this.ggs.frP.fsk, this.ggs.fwZ, 1)) {
            try {
                countDownLatch.await();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadNonIncremental semaphore exp ", new Object[0]);
            }
            return (WxaPkgWrappingInfo) hVar.value;
        }
        x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[]{this.ggs.appId, Integer.valueOf(this.ggs.fmv), Integer.valueOf(this.ggu)});
        this.ggs.a(a.fhG);
        return null;
    }
}
