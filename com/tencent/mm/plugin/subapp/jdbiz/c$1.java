package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.g.a.hn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$1 extends c<hn> {
    final /* synthetic */ c oqX;

    c$1(c cVar) {
        this.oqX = cVar;
        this.sFo = hn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hn hnVar = (hn) bVar;
        if (hnVar != null && (hnVar instanceof hn)) {
            hnVar.bQT.url = this.oqX.bGp();
        }
        return false;
    }
}
