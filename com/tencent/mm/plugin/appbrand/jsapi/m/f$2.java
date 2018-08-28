package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.r.g.a;

class f$2 implements a {
    final /* synthetic */ f fYz;

    f$2(f fVar) {
        this.fYz = fVar;
    }

    public final boolean i(Object... objArr) {
        synchronized (f.a(this.fYz)) {
            if (f.a(this.fYz).isEmpty()) {
                return false;
            }
            f.b(this.fYz).run();
            return true;
        }
    }
}
