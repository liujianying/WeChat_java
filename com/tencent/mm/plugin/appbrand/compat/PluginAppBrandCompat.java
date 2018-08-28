package com.tencent.mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.compat.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.c$a;
import com.tencent.mm.plugin.appbrand.m.d;

@Keep
public final class PluginAppBrandCompat extends f implements c, e {
    private final com.tencent.mm.sdk.b.c bannerOnInitListener = new 2(this);

    public final void installed() {
        super.installed();
        alias(e.class);
    }

    public final void configure(g gVar) {
    }

    public final void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.f.class, new com.tencent.mm.kernel.c.e(new d()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.d.class, new com.tencent.mm.kernel.c.e(new b()));
            com.tencent.mm.kernel.g.Ek().a(new 1(this));
        } else {
            com.tencent.mm.kernel.g.a(c$a.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.jsapi.p.d()));
        }
        com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.c.class, new com.tencent.mm.kernel.c.e(new k()));
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.bannerOnInitListener.cht();
    }

    public final void onAccountRelease() {
        this.bannerOnInitListener.dead();
    }
}
