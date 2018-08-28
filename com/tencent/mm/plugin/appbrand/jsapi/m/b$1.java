package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.m.b.b;
import com.tencent.mm.plugin.appbrand.l;

class b$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fYe;

    b$1(b bVar, l lVar, l lVar2) {
        this.fYe = bVar;
        this.fCl = lVar2;
        super(lVar);
    }

    public final void onDestroy() {
        e.b(this.fCl.mAppId, this);
        this.fYe.bgR.unregisterListener(this);
    }
}
