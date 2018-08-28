package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import java.util.ArrayList;

class b$1 implements l {
    final /* synthetic */ b uDf;

    b$1(b bVar) {
        this.uDf = bVar;
    }

    public final void b(j jVar) {
        if (jVar.bjW == 0) {
            b.a(this.uDf, jVar);
        } else {
            b.a(this.uDf, null);
        }
        if (jVar.jsx.size() == 0) {
            com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
            lVar.jrv = "no_result​";
            jVar.jsx = new ArrayList();
            jVar.jsx.add(lVar);
        }
        this.uDf.clearCache();
        this.uDf.notifyDataSetChanged();
        b.a(this.uDf).q(jVar.joH.bWm, jVar.jsx.size(), true);
    }
}
