package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class e$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ String dat;
    final /* synthetic */ c fJo;
    final /* synthetic */ b fVQ;
    final /* synthetic */ AppBrandLaunchReferrer fVR;
    final /* synthetic */ AppBrandStatObject fVS;
    final /* synthetic */ int fmg;

    e$1(b bVar, String str, AppBrandLaunchReferrer appBrandLaunchReferrer, c cVar, String str2, int i, AppBrandStatObject appBrandStatObject) {
        this.fVQ = bVar;
        this.dat = str;
        this.fVR = appBrandLaunchReferrer;
        this.fJo = cVar;
        this.bAj = str2;
        this.fmg = i;
        this.fVS = appBrandStatObject;
    }

    public final void b(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null) {
            if (this.fVQ != null) {
                this.fVQ.cT(true);
            }
            appBrandInitConfig.startTime = System.currentTimeMillis();
            appBrandInitConfig.fqx = com.tencent.mm.plugin.appbrand.appcache.a.qB(this.dat);
            appBrandInitConfig.fqA.a(this.fVR);
            e.a(this.fJo.getAppId(), e$c.LAUNCH_MINI_PROGRAM);
            if (appBrandInitConfig.aaq()) {
                g.ghE.a(this.fJo.getContext(), null, this.bAj, appBrandInitConfig.fqx, this.fmg, -1, this.fVS, this.fVR, null);
            } else if (this.fJo.getRuntime().aaq()) {
                e.c(this.fJo.getRuntime(), appBrandInitConfig, appBrandStatObject);
            } else {
                com.tencent.mm.plugin.appbrand.g runtime = this.fJo.getRuntime();
                runtime.fcr.a(runtime, appBrandInitConfig, this.fVS);
            }
        } else if (this.fVQ != null) {
            this.fVQ.cT(false);
        }
    }
}
