package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e$b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, e$b e_b, int i) {
        super(context, e_b, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        return ((n) g.n(n.class)).search(2, i.a(this.bWm, new int[]{131076}, null, -1, hashSet, b.jsU, this, agVar));
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -7;
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
            com.tencent.mm.plugin.fts.a.d.a.a a = a(131076, i, lVar, aVar);
            a.cF(lVar.type, lVar.jru);
            aVar2 = a;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        a aVar2 = new a(i2);
        aVar2.fyJ = lVar;
        aVar2.jrx = aVar.jrx;
        aVar2.cF(lVar.type, lVar.jru);
        return aVar2;
    }

    public final int getType() {
        return 4208;
    }
}
