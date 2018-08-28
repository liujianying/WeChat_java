package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.g;

class ao$2 extends e$b {
    final /* synthetic */ g fel;
    final /* synthetic */ ao fhV;

    ao$2(ao aoVar, g gVar) {
        this.fhV = aoVar;
        this.fel = gVar;
    }

    public final void onDestroy() {
        e.b(ao.a(this.fhV), this);
        synchronized (ao.acl()) {
            ao.acl().remove(this.fel);
        }
        ao.b(this.fhV);
    }
}
