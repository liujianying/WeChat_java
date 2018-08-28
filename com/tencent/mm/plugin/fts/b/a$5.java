package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.sh;
import com.tencent.mm.plugin.fts.b.a.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class a$5 extends c<sh> {
    final /* synthetic */ a jtJ;

    a$5(a aVar) {
        this.jtJ = aVar;
        this.sFo = sh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sh shVar = (sh) bVar;
        if (shVar.cdd.btC <= 0) {
            a.e(this.jtJ).a(131093, new u(this.jtJ, (byte) 0));
        } else if (a.h(this.jtJ).ciq()) {
            al h = a.h(this.jtJ);
            long j = shVar.cdd.btC;
            h.J(j, j);
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
        }
        return false;
    }
}
