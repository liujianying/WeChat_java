package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

class d$4 implements l {
    final /* synthetic */ d pOF;

    d$4(d dVar) {
        this.pOF = dVar;
    }

    public final void b(j jVar) {
        if (jVar.bjW == 0) {
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.jsx) {
                arrayList.add(lVar.content);
            }
            ah.A(new 1(this, jVar, arrayList));
        }
    }
}
