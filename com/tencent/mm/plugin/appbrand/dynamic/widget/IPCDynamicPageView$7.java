package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.modelappbrand.f;

class IPCDynamicPageView$7 implements Runnable {
    final /* synthetic */ IPCDynamicPageView fyl;
    final /* synthetic */ f fyn;
    final /* synthetic */ int fyo;

    IPCDynamicPageView$7(IPCDynamicPageView iPCDynamicPageView, f fVar, int i) {
        this.fyl = iPCDynamicPageView;
        this.fyn = fVar;
        this.fyo = i;
    }

    public final void run() {
        this.fyn.q(this.fyl, this.fyo);
    }
}
