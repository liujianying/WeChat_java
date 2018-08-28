package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.b;

class d$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ c fJo;
    final /* synthetic */ d fVO;

    d$1(d dVar, c cVar, int i) {
        this.fVO = dVar;
        this.fJo = cVar;
        this.doP = i;
    }

    public final void cT(boolean z) {
        this.fJo.E(this.doP, this.fVO.f(z ? "ok" : "fail", null));
    }
}
