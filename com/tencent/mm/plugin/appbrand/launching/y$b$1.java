package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.launching.y.b;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

class y$b$1 extends n {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ h fxa;
    final /* synthetic */ b ggv;

    y$b$1(b bVar, int i, h hVar, CountDownLatch countDownLatch) {
        this.ggv = bVar;
        this.fxa = hVar;
        this.dKv = countDownLatch;
        super(i);
    }

    final String akG() {
        return String.format(Locale.US, "NonIncremental %d", new Object[]{Integer.valueOf(b.a(this.ggv))});
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.fxa.value = wxaPkgWrappingInfo;
        this.dKv.countDown();
    }

    protected final void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        x.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[]{wxaPkgLoadProgress.toString()});
        if (wxaPkgLoadProgress.progress < 100) {
            this.ggv.ggs.onDownloadProgress(wxaPkgLoadProgress.progress);
        }
    }
}
