package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class e extends a {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.jsn = 64;
        iVar.bWm = this.bWm;
        iVar.jsq = new int[]{131072, 131081};
        iVar.jss = 3;
        iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
        iVar.jst = hashSet;
        iVar.jsv = this;
        iVar.handler = agVar;
        return ((n) g.n(n.class)).search(2, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
        aVar.iPZ = -4;
        aVar.jte = jVar.jsx;
        aVar.jtb = bk(jVar.jsx);
        aVar.jrx = jVar.jrx;
        if (aVar.jte.size() > 3) {
            aVar.jtd = true;
            aVar.jte = aVar.jte.subList(0, 3);
        }
        if (bk(jVar.jsx)) {
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        int i2 = 0;
        if (aVar.jtb) {
            int i3 = (i - aVar.jta) - 1;
            if (i3 < aVar.jte.size() && i3 >= 0) {
                l lVar = (l) aVar.jte.get(i3);
                aVar2 = a(lVar.type, i, lVar, aVar);
                if (aVar2 != null) {
                    aVar2.cF(lVar.type, lVar.jru);
                }
            }
            i2 = i3;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        if (lVar.type == 131072 || lVar.type == 131081) {
            r rVar = new r(i2);
            rVar.fyJ = lVar;
            rVar.jrx = aVar.jrx;
            rVar.cF(lVar.type, lVar.jru);
            return rVar;
        } else if (lVar.type == 131073 || lVar.type == 131074) {
            return ((a) ((n) g.n(n.class)).createFTSUIUnit(33, this.context, this.jsY, this.jsZ)).a(i, i2, lVar, aVar);
        } else {
            return null;
        }
    }
}
