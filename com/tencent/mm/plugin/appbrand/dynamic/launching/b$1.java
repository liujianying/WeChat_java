package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.plugin.appbrand.appcache.aq.b;
import com.tencent.mm.plugin.appbrand.appcache.base.b$a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class b$1 implements a {
    final /* synthetic */ CountDownLatch dKv;
    final /* synthetic */ h fxa;
    final /* synthetic */ b fxb;

    b$1(b bVar, h hVar, CountDownLatch countDownLatch) {
        this.fxb = bVar;
        this.fxa = hVar;
        this.dKv = countDownLatch;
    }

    public final /* bridge */ /* synthetic */ void a(k kVar) {
    }

    public final /* synthetic */ void a(String str, b$a.a aVar, Object obj) {
        b bVar = (b) obj;
        x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, appId = %s, return = %s", new Object[]{str, aVar.name()});
        if (b$a.a.fio.equals(aVar)) {
            WxaPkgWrappingInfo qX = WxaPkgWrappingInfo.qX(bVar.filePath);
            if (qX == null) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                qX.fii = bVar.version;
                qX.fij = bi.VE();
                qX.fih = bVar.fig;
                this.fxa.value = qX;
            }
        } else {
            b$a.a.fit.equals(aVar);
        }
        this.dKv.countDown();
    }
}
