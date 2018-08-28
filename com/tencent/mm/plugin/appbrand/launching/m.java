package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.launching.j.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class m implements i {
    final String appId;
    final int fmv;
    final String fqx;
    final List<e> fsl;
    final String fsn;
    final int gfL;
    final int gfM;
    final int gfw;

    public /* synthetic */ Object call() {
        String str;
        int i;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        h hVar = new h();
        h hVar2 = new h();
        j f = a.f(this.appId, "__APP__", this.fmv, this.gfL);
        f.a(new 1(this, hVar, countDownLatch));
        f.prepareAsync();
        String vP = bi.oW(this.fqx) ? "" : l.vP(this.fqx);
        if (bi.oW(vP)) {
            str = this.fsn;
        } else {
            String str2;
            for (e eVar : this.fsl) {
                if (vP.startsWith(com.tencent.mm.plugin.appbrand.appcache.a.qB(eVar.name))) {
                    str2 = eVar.name;
                    break;
                }
            }
            str2 = null;
            str = bi.oW(str2) ? this.fsn : str2;
        }
        if ("__APP__".equals(str) || bi.oW(str)) {
            countDownLatch.countDown();
            i = 0;
        } else {
            f = a.f(this.appId, str, this.fmv, this.gfL);
            f.a(new 2(this, hVar2, countDownLatch));
            f.prepareAsync();
            i = 1;
        }
        countDownLatch.await();
        if (hVar.value == null) {
            x.e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), main module not ready");
            return null;
        } else if (i == 0 || hVar2.value != null) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) hVar.value;
            for (e eVar2 : this.fsl) {
                if (!"__APP__".equals(eVar2.name)) {
                    ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
                    modulePkgInfo.name = eVar2.name;
                    modulePkgInfo.bKg = eVar2.bKg;
                    wxaPkgWrappingInfo.fil.add(modulePkgInfo);
                    if (i != 0 && str.equals(modulePkgInfo.name)) {
                        modulePkgInfo.ffK = ((WxaPkgWrappingInfo) hVar2.value).ffK;
                    }
                }
            }
            return wxaPkgWrappingInfo;
        } else {
            x.e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), checkEntranceModule %s but not ready", new Object[]{str});
            return null;
        }
    }

    m(String str, int i, String str2, int i2, int i3, int i4, String str3, List<e> list) {
        this.appId = str;
        this.fmv = i;
        this.fqx = str2;
        this.gfw = i2;
        this.gfL = i3;
        this.gfM = i4;
        this.fsn = str3;
        this.fsl = list;
    }

    public final void onDownloadProgress(int i) {
    }
}
