package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.i.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ a fVX;

    a$2(a aVar, l lVar) {
        this.fVX = aVar;
        this.fCl = lVar;
    }

    public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
        x.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[]{this.fVX.fVW, wxaPkgLoadProgress.toString()});
        this.fVX.mTotalSize = wxaPkgLoadProgress.fiy;
        a.a.a(this.fCl, this.fVX.fEl, "progressUpdate", this.fVX.fVW, wxaPkgLoadProgress.progress, wxaPkgLoadProgress.fix, wxaPkgLoadProgress.fiy);
    }
}
