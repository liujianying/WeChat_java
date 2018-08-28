package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements a {
    final /* synthetic */ k ujC;

    k$2(k kVar) {
        this.ujC = kVar;
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!k.b(this.ujC).ciq()) {
            k.b(this.ujC).SO();
        }
        al b = k.b(this.ujC);
        long j = k.c(this.ujC) ? 500 : 1000;
        b.J(j, j);
    }
}
