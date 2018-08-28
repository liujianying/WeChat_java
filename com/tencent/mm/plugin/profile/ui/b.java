package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import java.util.List;

public final class b extends m {
    private String bWm;
    private ab guS;
    private ag handler = new ag();
    private a jsw;
    private List<l> jte;
    private com.tencent.mm.plugin.fts.a.l lUA = new com.tencent.mm.plugin.fts.a.l() {
        public final void b(j jVar) {
            if (jVar.bjW == 0) {
                b.this.jte = jVar.jsx;
                if (b.this.ujV != null) {
                    b.this.ujV.q(jVar.joH.bWm, b.this.jte.size(), true);
                }
            }
            b.this.notifyDataSetChanged();
        }
    };

    public b(com.tencent.mm.ui.contact.l lVar, int i, ab abVar) {
        super(lVar, false, i);
        this.guS = abVar;
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        e eVar = new e(i);
        au.HU();
        eVar.guS = c.FR().Yg(((l) this.jte.get(i)).jrv);
        return eVar;
    }

    public final int getCount() {
        if (this.jte == null) {
            return 0;
        }
        return this.jte.size();
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.bWm = str;
        i iVar = new i();
        iVar.bWm = str;
        iVar.handler = this.handler;
        iVar.jsv = this.lUA;
        iVar.jso = this.guS.field_username;
        iVar.jsn = 7;
        this.jsw = ((n) g.n(n.class)).search(2, iVar);
    }

    public final void acV() {
        this.bWm = null;
        if (this.jsw != null) {
            ((n) g.n(n.class)).cancelSearchTask(this.jsw);
        }
    }
}
