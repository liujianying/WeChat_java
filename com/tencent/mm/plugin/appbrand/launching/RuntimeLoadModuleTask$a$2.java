package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a;
import com.tencent.mm.sdk.platformtools.x;

class RuntimeLoadModuleTask$a$2 implements j$b {
    final /* synthetic */ a ggO;

    RuntimeLoadModuleTask$a$2(a aVar) {
        this.ggO = aVar;
    }

    public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
        x.i("MicroMsg.AppBrand.RuntimeLoadModuleTask", "hy: prepare job progress callback, %s", new Object[]{wxaPkgLoadProgress.toString()});
        if (a.a(this.ggO) != null) {
            a.a(this.ggO).at(new RuntimeLoadModuleTask$WxaPkgResultProgressPair(wxaPkgLoadProgress));
        }
    }
}
