package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.config.d.a;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements a {
    final /* synthetic */ g fdd;

    g$3(g gVar) {
        this.fdd = gVar;
    }

    public final void a(d$b d_b, boolean z) {
        x.i("MicroMsg.AppBrandRuntime", "resume OnOrientationChanged orientation = [%s] success = [%b]", new Object[]{d_b, Boolean.valueOf(z)});
    }
}
