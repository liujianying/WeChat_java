package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashSet;
import java.util.List;

public final class m extends a {
    private boolean jzm = false;

    public m(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        String str = (String) g.Ei().DT().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.jzm = z;
        this.jzm &= bi.fU(context);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.jsq = this.jzm ? new int[]{131072, 131075, 131073, 131074, 262144, 131076} : new int[]{131072, 131075, 262144, 131076};
        iVar.jss = 3;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.scene = 0;
        iVar.jst = hashSet;
        if (this.bWm.startsWith("@@")) {
            iVar.bWm = this.bWm.substring(2);
            return ((n) g.n(n.class)).search(10000, iVar);
        }
        iVar.bWm = this.bWm;
        return ((n) g.n(n.class)).search(1, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        for (l lVar : jVar.jsx) {
            hashSet.add(lVar.jrv);
        }
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -8;
            List list = jVar.jsx;
            if (com.tencent.mm.plugin.fts.a.d.b.bk(list) && list.size() > 3) {
                list = list.subList(0, 3);
            }
            aVar.jte = list;
            aVar.jtd = false;
            aVar.jrx = jVar.jrx;
            this.jvp.add(aVar);
        }
        d.bj(jVar.jsx);
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a a;
        int i2 = (i - aVar.jta) - 1;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            a aVar2 = lVar.type == 131075 ? (a) ((n) g.n(n.class)).createFTSUIUnit(48, this.context, this.jsY, this.jsZ) : (lVar.type == 131072 || lVar.type == 131073 || lVar.type == 131074) ? (a) ((n) g.n(n.class)).createFTSUIUnit(32, this.context, this.jsY, this.jsZ) : lVar.type == 262144 ? (a) ((n) g.n(n.class)).createFTSUIUnit(64, this.context, this.jsY, this.jsZ) : lVar.type == 131076 ? (a) ((n) g.n(n.class)).createFTSUIUnit(96, this.context, this.jsY, this.jsZ) : null;
            if (aVar2 != null) {
                a = aVar2.a(lVar.type, i, lVar, aVar);
                if (a != null) {
                    a.jtm = i2 + 1;
                }
                return a;
            }
        }
        a = null;
        if (a != null) {
            a.jtm = i2 + 1;
        }
        return a;
    }

    public final int getType() {
        return 16;
    }
}
