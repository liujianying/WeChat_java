package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class e$17 extends c<p> {
    final /* synthetic */ e ffn;

    e$17(e eVar) {
        this.ffn = eVar;
        this.sFo = p.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        p pVar = (p) bVar;
        if (!bi.oW(pVar.bGN.bGy)) {
            String str = pVar.bGN.bGy;
            e.abf().bd(str + "_unreadCount", pVar.bGN.bGz);
            d.aB(q.rW(str), pVar.bGN.bGz);
        }
        return false;
    }
}
