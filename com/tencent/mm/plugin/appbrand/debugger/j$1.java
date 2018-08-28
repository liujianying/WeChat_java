package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.debugger.q.a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$c;

class j$1 implements a {
    final /* synthetic */ j fti;

    j$1(j jVar) {
        this.fti = jVar;
    }

    public final void aeA() {
        this.fti.destroy();
        e.a(this.fti.fcy.mAppId, e$c.CLOSE);
        this.fti.ftd.finish();
    }
}
