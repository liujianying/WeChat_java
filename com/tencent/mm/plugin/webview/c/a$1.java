package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.g.a.lx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$1 extends c<lx> {
    final /* synthetic */ a pNE;

    a$1(a aVar) {
        this.pNE = aVar;
        this.sFo = lx.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        lx lxVar = (lx) bVar;
        if (!(lxVar instanceof lx)) {
            return false;
        }
        this.pNE.pNC.a(lxVar.bWl.type, lxVar.bWl.bWm, lxVar.bWl.bWn, lxVar.bWl.bWo, lxVar.bWl.bWp);
        return true;
    }
}
