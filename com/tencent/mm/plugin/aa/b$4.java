package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.bp;
import com.tencent.mm.plugin.aa.a.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class b$4 extends c<bp> {
    final /* synthetic */ b ezx;

    b$4(b bVar) {
        this.ezx = bVar;
        this.sFo = bp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bp bpVar = (bp) bVar;
        if (!(bi.oW(bpVar.bJa.bIX) || bi.oW(bpVar.bJa.bIY))) {
            new d(bpVar.bJa.bIX, bpVar.bJa.bIY).KM().h(new 1(this, bpVar));
        }
        return false;
    }
}
