package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ar.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.bi;

class d$3 implements Runnable {
    final /* synthetic */ d gfB;
    final /* synthetic */ String gfC;

    d$3(d dVar, String str) {
        this.gfB = dVar;
        this.gfC = str;
    }

    public final void run() {
        String[] rV = q.rV(this.gfC);
        if (rV != null && rV.length > 0) {
            for (String str : rV) {
                b Ka = b.Ka();
                if (!bi.oW(str)) {
                    Ka.a(new b.b(), str, null);
                }
            }
        }
        if (g.Ei().isSDCardAvailable()) {
            g.Eh().dpP.a(new k(12), 0);
        }
    }
}
