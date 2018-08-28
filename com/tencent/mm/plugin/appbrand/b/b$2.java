package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.g;

class b$2 extends c {
    final /* synthetic */ b fjm;

    b$2(b bVar, g gVar) {
        this.fjm = bVar;
        super(gVar);
    }

    final void acu() {
        b.a(this.fjm);
    }

    final void b(a aVar) {
        b bVar = this.fjm;
        synchronized (bVar.fjk) {
        }
        for (b$a b_a : (b$a[]) bVar.fjk.keySet().toArray(new b$a[bVar.fjk.size()])) {
            String str = bVar.fdO.mAppId;
            b_a.a(aVar);
        }
    }
}
