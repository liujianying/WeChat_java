package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$LaunchPreconditionTask.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.2;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import junit.framework.Assert;

class JsApiLaunchMiniProgram$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ String dat;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fVB;
    final /* synthetic */ JsApiLaunchMiniProgram fVC;
    final /* synthetic */ int fmg;

    JsApiLaunchMiniProgram$1(JsApiLaunchMiniProgram jsApiLaunchMiniProgram, l lVar, String str, int i, String str2, String str3, int i2) {
        this.fVC = jsApiLaunchMiniProgram;
        this.fCl = lVar;
        this.bAj = str;
        this.fmg = i;
        this.dat = str2;
        this.fVB = str3;
        this.doP = i2;
    }

    public final void run() {
        JsApiLaunchMiniProgram jsApiLaunchMiniProgram = this.fVC;
        l lVar = this.fCl;
        String str = this.bAj;
        int i = this.fmg;
        String str2 = this.dat;
        String str3 = this.fVB;
        int i2 = this.doP;
        JsApiLaunchMiniProgram$LaunchPreconditionTask jsApiLaunchMiniProgram$LaunchPreconditionTask = new JsApiLaunchMiniProgram$LaunchPreconditionTask();
        jsApiLaunchMiniProgram$LaunchPreconditionTask.fVF = str;
        jsApiLaunchMiniProgram$LaunchPreconditionTask.fVG = i;
        if (AppBrandMainProcessService.b(jsApiLaunchMiniProgram$LaunchPreconditionTask)) {
            a kP = a.kP(jsApiLaunchMiniProgram$LaunchPreconditionTask.fVH);
            if (kP == null) {
                kP = a.fVI;
            }
            if (a.fVK != kP) {
                lVar.E(i2, jsApiLaunchMiniProgram.f(kP.bIr, null));
                return;
            }
            e.a(lVar.mAppId, e$c.LAUNCH_MINI_PROGRAM);
            MMToClientEvent.a(new 2(jsApiLaunchMiniProgram, str, i, lVar, i2));
            if (lVar.getContext() != null && (lVar.getContext() instanceof Activity) && !lVar.getContext().isFinishing()) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1037;
                AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(lVar.mAppId);
                if (qb != null) {
                    appBrandStatObject.cbA = qb.cbA;
                }
                String str4 = "";
                p d = JsApiLaunchMiniProgram.d(lVar);
                if (d != null) {
                    str4 = d.ahc();
                }
                appBrandStatObject.bGG = lVar.mAppId + ":" + lVar.fdO.fct.fdE;
                AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                appBrandLaunchReferrer.appId = lVar.mAppId;
                appBrandLaunchReferrer.fqF = str3;
                appBrandLaunchReferrer.fqE = 1;
                appBrandLaunchReferrer.url = str4;
                AppBrandLaunchProxyUI.a(lVar.getContext(), null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                Assert.assertTrue(true);
                return;
            }
            return;
        }
        lVar.E(i2, jsApiLaunchMiniProgram.f("fail precondition error", null));
    }
}
