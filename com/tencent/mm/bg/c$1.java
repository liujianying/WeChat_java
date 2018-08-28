package com.tencent.mm.bg;

import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;

class c$1 extends a {
    final /* synthetic */ String qVb;
    final /* synthetic */ p qVc;

    c$1(String str, p pVar) {
        this.qVb = str;
        this.qVc = pVar;
    }

    public final void execute(g gVar) {
        String str = this.qVb;
        p pVar = this.qVc;
        d.a(str, c.qUZ, c.qVa);
        if (pVar == null) {
            pVar = new p(c.Un(str));
        }
        p.a("plugin." + str, pVar);
    }
}
