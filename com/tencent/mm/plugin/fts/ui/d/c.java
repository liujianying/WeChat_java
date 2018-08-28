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
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.jsn = 96;
        iVar.jss = 3;
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
            aVar.jte = jVar.jsx;
            aVar.iPZ = -3;
            aVar.jrx = jVar.jrx;
            if (aVar.jte.size() > 3) {
                if (((l) aVar.jte.get(3)).jrv.equals("create_chatroom​")) {
                    boolean z;
                    if (aVar.jte.size() > 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.jtd = z;
                    aVar.jte = aVar.jte.subList(0, 4);
                } else {
                    aVar.jtd = true;
                    aVar.jte = aVar.jte.subList(0, 3);
                }
            }
            this.jvp.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a hVar;
        int i2 = (i - aVar.jta) - 1;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            if (lVar.jrv.equals("create_chatroom​")) {
                hVar = new h(i);
                hVar.jrx = aVar.jrx;
            } else if (lVar.type == 131075) {
                com.tencent.mm.plugin.fts.a.d.a.a a = a(131075, i, lVar, aVar);
                a.cF(lVar.type, lVar.jru);
                hVar = a;
            }
            if (hVar != null) {
                hVar.jtm = i2 + 1;
            }
            return hVar;
        }
        hVar = null;
        if (hVar != null) {
            hVar.jtm = i2 + 1;
        }
        return hVar;
    }

    public final int getType() {
        return 48;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a qVar = new q(i2);
        qVar.fyJ = lVar;
        qVar.jrx = aVar.jrx;
        qVar.cF(lVar.type, lVar.jru);
        return qVar;
    }
}
