package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class g extends l {
    public String jso;
    public int showType;
    public String talker;

    public g(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return 192;
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        this.jzn = false;
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jsu = e.jsX;
        iVar.jso = this.jso;
        iVar.jsp = this.jsp;
        iVar.talker = this.talker;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jsn = 11;
        return ((n) com.tencent.mm.kernel.g.n(n.class)).search(3, iVar);
    }

    protected final k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        f fVar = new f(i);
        fVar.jxW = aVar.jtg;
        fVar.jso = this.jso;
        return fVar;
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2;
        if (aVar.jtb) {
            i2 = (i - aVar.jta) - 1;
        } else {
            i2 = i - aVar.jta;
        }
        if (i2 < 0 || i2 >= aVar.jte.size()) {
            return null;
        }
        l lVar = (l) aVar.jte.get(i2);
        if (lVar.jrv.equals("no_result​")) {
            return new com.tencent.mm.plugin.fts.ui.a.l(i);
        }
        com.tencent.mm.plugin.fts.ui.a.g gVar = new com.tencent.mm.plugin.fts.ui.a.g(i);
        gVar.fyJ = lVar;
        gVar.jrx = gVar.fyJ.jrx;
        gVar.cF(lVar.type, lVar.jru);
        return gVar;
    }

    public final int aQR() {
        return this.showType;
    }
}
