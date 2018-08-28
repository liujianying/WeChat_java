package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;

class q$1 extends n {
    final /* synthetic */ q gfY;

    q$1(q qVar, int i) {
        this.gfY = qVar;
        super(i);
    }

    final String akG() {
        return this.gfY.akH();
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.gfY.d(wxaPkgWrappingInfo);
    }

    protected final void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        super.c(wxaPkgLoadProgress);
        this.gfY.d(wxaPkgLoadProgress);
    }
}
