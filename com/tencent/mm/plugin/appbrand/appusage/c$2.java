package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;

class c$2 implements Runnable {
    final /* synthetic */ c fld;

    public c$2(c cVar) {
        this.fld = cVar;
    }

    public final void run() {
        if (g.Eg().Dx() && !b.acJ()) {
            c.a(this.fld, 2, 7, 0, true, null);
        }
    }
}
