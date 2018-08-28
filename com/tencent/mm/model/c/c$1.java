package com.tencent.mm.model.c;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c dEF;

    c$1(c cVar) {
        this.dEF = cVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + a);
        a.a ja = a.ja(a);
        if (ja != null) {
            c.Jx().j(ja.dEw, 1);
            c.Jy().j(ja.dEx, 2);
        }
    }
}
