package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class d extends a {
    public d(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jsq = new int[]{131072, 131081};
        iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
        iVar.jst = hashSet;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jsn = 16;
        return ((n) g.n(n.class)).search(2, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -4;
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
            r rVar = new r(i);
            rVar.fyJ = lVar;
            rVar.jrx = aVar.jrx;
            rVar.cF(lVar.type, lVar.jru);
            aVar2 = rVar;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4112;
    }
}
