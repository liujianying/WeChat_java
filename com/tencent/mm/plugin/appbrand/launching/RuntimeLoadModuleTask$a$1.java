package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.WxaPkgResultProgressPair;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a;
import com.tencent.mm.plugin.appbrand.launching.j.c;

class RuntimeLoadModuleTask$a$1 implements c {
    final /* synthetic */ a ggO;

    RuntimeLoadModuleTask$a$1(a aVar) {
        this.ggO = aVar;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (a.a(this.ggO) != null) {
            a.a(this.ggO).at(new WxaPkgResultProgressPair(wxaPkgWrappingInfo));
            a.b(this.ggO);
        }
    }
}
