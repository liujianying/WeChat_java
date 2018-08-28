package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.jsn = 32;
        iVar.bWm = this.bWm;
        iVar.jst = hashSet;
        iVar.jsu = com.tencent.mm.plugin.fts.a.c.a.jsT;
        iVar.jsv = this;
        iVar.handler = agVar;
        return ((n) g.n(n.class)).search(2, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -3;
            aVar.jte = jVar.jsx;
            aVar.jrx = jVar.jrx;
            aVar.jtd = false;
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2 = (i - aVar.jta) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            if (lVar.jrv.equals("create_chatroom​")) {
                aVar2 = new h(i);
                aVar2.jrx = aVar.jrx;
            } else {
                com.tencent.mm.plugin.fts.a.d.a.a qVar = new q(i);
                qVar.fyJ = lVar;
                qVar.jrx = aVar.jrx;
                qVar.cF(lVar.type, lVar.jru);
                aVar2 = qVar;
            }
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4128;
    }
}
