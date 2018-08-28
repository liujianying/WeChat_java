package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class h extends a {
    public h(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.handler = agVar;
        iVar.jst = hashSet;
        iVar.jsv = this;
        iVar.jsu = c.jsV;
        return ((n) g.n(n.class)).search(4, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -6;
            aVar.jrx = jVar.jrx;
            aVar.jte = jVar.jsx;
            aVar.jtd = false;
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2 = (i - aVar.jta) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            aVar2 = a(262144, i, (l) aVar.jte.get(i2), aVar);
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 64;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        com.tencent.mm.plugin.fts.ui.a.j jVar = new com.tencent.mm.plugin.fts.ui.a.j(i2);
        jVar.fyJ = lVar;
        jVar.jrx = aVar.jrx;
        jVar.cF(lVar.type, lVar.jru);
        return jVar;
    }
}
