package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.jsn = 2;
        iVar.bWm = this.bWm;
        iVar.jst = hashSet;
        iVar.handler = agVar;
        iVar.jsv = this;
        iVar.jsu = d.jsW;
        return ((n) g.n(n.class)).search(6, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -1;
            aVar.jrx = jVar.jrx;
            aVar.jte = jVar.jsx;
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2 = (i - aVar.jta) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            a aVar3 = new a(i);
            aVar3.fyJ = lVar;
            aVar3.jrx = aVar.jrx;
            aVar3.cF(lVar.type, lVar.jru);
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4192;
    }
}
