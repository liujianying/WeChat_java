package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f extends k {
    public String jso;
    public u jwq;

    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return 160;
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        this.jzn = false;
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jso = this.jso;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jsn = 3;
        return ((n) g.n(n.class)).search(3, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        List list = jVar.jsx;
        if (bk(list)) {
            if (list.size() > 0) {
                l lVar = (l) list.get(0);
                if (lVar.jrv.equals("create_talker_message​")) {
                    e.a aVar = new e.a();
                    aVar.jtb = false;
                    aVar.jte = new ArrayList();
                    aVar.jte.add(lVar);
                    aVar.jrx = jVar.jrx;
                    aVar.iPZ = -2;
                    this.jvp.add(aVar);
                    list.remove(0);
                }
            }
            e.a aVar2 = new e.a();
            aVar2.iPZ = -2;
            aVar2.jrx = jVar.jrx;
            if (list.size() == 0) {
                aVar2.jtb = false;
                l lVar2 = new l();
                lVar2.jrv = "no_result​";
                aVar2.jte = new ArrayList();
                aVar2.jte.add(lVar2);
            } else {
                aVar2.jte = list;
            }
            this.jvp.add(aVar2);
        }
    }

    protected final k b(int i, e.a aVar) {
        com.tencent.mm.plugin.fts.ui.a.e eVar = new com.tencent.mm.plugin.fts.ui.a.e(i);
        eVar.talker = this.jso;
        eVar.count = aVar.jte.size();
        return eVar;
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2;
        int i3 = i - aVar.jta;
        if (aVar.jtb) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            if (lVar.jrv.equals("create_talker_message​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.i(i);
                aVar2.jtj = false;
                aVar2.jso = this.jso;
                this.jzn = true;
            } else if (lVar.jrv.equals("no_result​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.l(i);
            } else {
                d dVar = new d(i2);
                dVar.fyJ = lVar;
                dVar.jrx = aVar.jrx;
                dVar.jwq = this.jwq;
                dVar.cF(lVar.type, lVar.jru);
                aVar2 = dVar;
            }
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
            aVar2.jrx = aVar.jrx;
        }
        return aVar2;
    }
}
