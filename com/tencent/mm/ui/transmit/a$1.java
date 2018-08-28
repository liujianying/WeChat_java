package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.ui.transmit.a.a;
import java.util.ArrayList;

class a$1 implements l {
    final /* synthetic */ a uDa;

    a$1(a aVar) {
        this.uDa = aVar;
    }

    public final void b(j jVar) {
        a aVar = new a(this.uDa, (byte) 0);
        aVar.bWm = jVar.joH.bWm;
        aVar.jrx = jVar.jrx;
        aVar.jsx = jVar.jsx;
        if (aVar.jsx == null || aVar.jsx.size() == 0) {
            com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
            lVar.jrv = "no_result​";
            aVar.jsx = new ArrayList();
            aVar.jsx.add(lVar);
        }
        a.a(this.uDa).add(aVar);
        a.b(this.uDa);
    }
}
