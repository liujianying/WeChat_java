package com.tencent.mm.vending.app;

import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.base.a.a;
import com.tencent.mm.vending.g.g;

class a$2 implements a {
    final /* synthetic */ a uPO;

    a$2(a aVar) {
        this.uPO = aVar;
    }

    public final /* synthetic */ void cr(Object obj) {
        Class cls = (Class) obj;
        c cVar = (c) this.uPO.uPM.get(cls);
        if (cVar != null) {
            cVar.a(g.cy(this.uPO.uPJ.get(cls)));
        }
    }
}
