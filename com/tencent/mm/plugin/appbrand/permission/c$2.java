package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.e.b;

class c$2 extends b {
    final /* synthetic */ String bAj;
    final /* synthetic */ c gqn;

    c$2(c cVar, String str) {
        this.gqn = cVar;
        this.bAj = str;
    }

    public final void onDestroy() {
        synchronized (c.amp()) {
            c.amp().remove(this.bAj);
        }
        c.a(this.gqn);
    }
}
