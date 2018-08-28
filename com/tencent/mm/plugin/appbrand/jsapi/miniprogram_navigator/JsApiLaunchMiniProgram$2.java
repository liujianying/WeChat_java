package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;

class JsApiLaunchMiniProgram$2 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiLaunchMiniProgram fVC;
    final /* synthetic */ String fVD;
    final /* synthetic */ int fVE;

    JsApiLaunchMiniProgram$2(JsApiLaunchMiniProgram jsApiLaunchMiniProgram, String str, int i, l lVar, int i2) {
        this.fVC = jsApiLaunchMiniProgram;
        this.fVD = str;
        this.fVE = i;
        this.fCl = lVar;
        this.doP = i2;
    }

    public final void bj(Object obj) {
        if (obj instanceof LaunchBroadCast) {
            LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
            if (this.fVD.equals(launchBroadCast.appId) && this.fVE == launchBroadCast.fmv) {
                MMToClientEvent.b(this);
                this.fCl.E(this.doP, this.fVC.f(launchBroadCast.cdk ? "ok" : "fail", null));
            }
        }
    }
}
