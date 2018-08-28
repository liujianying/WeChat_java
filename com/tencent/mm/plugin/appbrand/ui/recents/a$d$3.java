package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class a$d$3 implements Runnable {
    final /* synthetic */ d gzn;
    final /* synthetic */ k gzo;

    a$d$3(d dVar, k kVar) {
        this.gzn = dVar;
        this.gzo = kVar;
    }

    public final void run() {
        e.abh().g(this.gzo.bGy, this.gzo.fig, true);
        a.b(this.gzo.appId, this.gzo.fig + 1, 2, 1, a.t(this.gzn.gyS));
    }
}
