package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class e extends a {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jsu = d.jsW;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jst = hashSet;
        iVar.jsu = h.fAM;
        return ((n) g.n(n.class)).search(10, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
            aVar.iPZ = -15;
            aVar.jrx = jVar.jrx;
            aVar.jte = jVar.jsx;
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2 = (i - aVar.jta) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            c cVar = new c(i);
            cVar.fyJ = lVar;
            cVar.jrx = aVar.jrx;
            cVar.cF(lVar.type, lVar.jru);
            aVar2 = cVar;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4240;
    }
}
