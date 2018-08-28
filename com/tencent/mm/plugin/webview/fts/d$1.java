package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.fts.d.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class d$1 implements l {
    final /* synthetic */ d pOF;

    d$1(d dVar) {
        this.pOF = dVar;
    }

    public final void b(j jVar) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[]{Integer.valueOf(jVar.bjW), Integer.valueOf(((f) jVar.joH).pOW)});
        if (jVar.bjW == 0) {
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.jsx) {
                arrayList.add(lVar.content);
            }
            ah.A(new 1(this, r0, jVar, arrayList));
        }
    }
}
