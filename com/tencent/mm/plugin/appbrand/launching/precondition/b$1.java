package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;

class b$1 implements Runnable {
    final /* synthetic */ b ghq;

    b$1(b bVar) {
        this.ghq = bVar;
    }

    public final void run() {
        ((AppBrandLaunchProxyUI) this.ghq.getBaseContext()).finish();
    }
}
