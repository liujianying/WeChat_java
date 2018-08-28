package com.tencent.mm.plugin.appbrand.f;

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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;

public final class f extends a {
    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jsu = d.jsW;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jst = hashSet;
        return ((n) g.n(n.class)).search(7, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        List list = jVar.jsx;
        if (!(list == null || list.isEmpty())) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            String str = this.bWm;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            dVar.r("20KeyWordId", str + ",");
            dVar.r("21ViewType", "2,");
            dVar.r("22OpType", "1,");
            dVar.r("23ResultCount", list.size() + ",");
            dVar.r("24ClickPos", ",");
            dVar.r("25ClickAppUserName", ",");
            x.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[]{dVar.wF()});
            h.mEJ.h(13963, new Object[]{dVar});
        }
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -13;
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
            d dVar = new d(i);
            dVar.fyJ = lVar;
            dVar.jrx = aVar.jrx;
            dVar.cF(lVar.type, lVar.jru);
            aVar2 = dVar;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4224;
    }
}
