package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.launching.j.b;
import com.tencent.mm.plugin.appbrand.launching.j.c;
import com.tencent.mm.sdk.f.e;

public abstract class o implements j {
    public volatile c gfQ;
    private volatile b gfR;
    final r gfS;

    public abstract String akH();

    public abstract void prepare();

    o(r rVar) {
        this.gfS = rVar;
    }

    final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        c cVar = this.gfQ;
        if (cVar != null) {
            cVar.b(wxaPkgWrappingInfo);
        }
    }

    final void d(WxaPkgLoadProgress wxaPkgLoadProgress) {
        b bVar = this.gfR;
        if (bVar != null) {
            bVar.b(wxaPkgLoadProgress);
        }
    }

    public final void a(c cVar) {
        this.gfQ = cVar;
    }

    public final void a(b bVar) {
        this.gfR = bVar;
    }

    public final void prepareAsync() {
        e.post(new 1(this), "AppBrandLaunchPrepareJob#" + akH());
    }
}
