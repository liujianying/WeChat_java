package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a extends o implements l {
    ab guS;
    ag handler = new ag(Looper.getMainLooper());
    private List<com.tencent.mm.plugin.fts.a.a.l> jte;

    public a(com.tencent.mm.ui.contact.l lVar, int i, ab abVar) {
        super(lVar, new ArrayList(), true, false, i);
        this.guS = abVar;
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        e eVar = new e(i);
        au.HU();
        eVar.guS = c.FR().Yg(((com.tencent.mm.plugin.fts.a.a.l) this.jte.get(i)).jrv);
        return eVar;
    }

    public final int getCount() {
        if (this.jte == null) {
            return 0;
        }
        return this.jte.size();
    }

    public final void b(j jVar) {
        if (jVar.bjW == 0) {
            this.jte = jVar.jsx;
        }
        notifyDataSetChanged();
    }
}
