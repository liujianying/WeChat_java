package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.b;
import com.tencent.mm.plugin.appbrand.l;

class JsApiNavigateToDevMiniProgram$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiNavigateToDevMiniProgram fVM;

    JsApiNavigateToDevMiniProgram$1(JsApiNavigateToDevMiniProgram jsApiNavigateToDevMiniProgram, l lVar, int i) {
        this.fVM = jsApiNavigateToDevMiniProgram;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void cT(boolean z) {
        this.fCl.E(this.doP, this.fVM.f(z ? "ok" : "fail", null));
    }
}
