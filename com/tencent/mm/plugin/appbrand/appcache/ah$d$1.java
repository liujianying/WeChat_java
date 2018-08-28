package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ah.d;
import com.tencent.mm.pluginsdk.g.a.c.e;
import com.tencent.mm.pluginsdk.g.a.c.m;

class ah$d$1 implements Runnable {
    final /* synthetic */ m fht;
    final /* synthetic */ e fhu;
    final /* synthetic */ d fhv;

    ah$d$1(d dVar, m mVar, e eVar) {
        this.fhv = dVar;
        this.fht = mVar;
        this.fhu = eVar;
    }

    public final void run() {
        switch (this.fht.status) {
            case 2:
                d.c(this.fhu, this.fht);
                return;
            case 3:
                d.b(this.fhu, this.fht);
                return;
            case 4:
                d.d(this.fhu, this.fht);
                return;
            default:
                return;
        }
    }
}
