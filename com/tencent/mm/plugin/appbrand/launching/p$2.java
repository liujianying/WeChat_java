package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;

class p$2 extends n {
    final /* synthetic */ p gfX;

    p$2(p pVar) {
        this.gfX = pVar;
        super(0);
    }

    final String akG() {
        return this.gfX.akH();
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.gfX.d(wxaPkgWrappingInfo);
    }

    protected final void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        this.gfX.d(wxaPkgLoadProgress);
    }
}
