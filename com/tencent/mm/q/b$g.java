package com.tencent.mm.q;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class b$g extends h {
    final /* synthetic */ b dhZ;
    private int[] dip;
    private int[] diq;

    public b$g(b bVar, i iVar) {
        this.dhZ = bVar;
        super(iVar);
        this.dip = iVar.jsq;
        this.diq = iVar.jsr;
    }

    protected final void a(j jVar) {
        String str;
        super.a(jVar);
        a aVar = this.dhZ.dhX;
        String[] strArr = jVar.jrx.jrX;
        int[] iArr = this.dip;
        int[] iArr2 = this.diq;
        String u = d.u(strArr);
        String format = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{aVar.aPV(), Integer.valueOf(strArr.length)});
        String str2 = "";
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.l(iArr2);
        if (iArr == null || iArr.length <= 0) {
            str = "";
        } else {
            str = " AND type IN " + d.l(iArr);
        }
        Cursor Cm = aVar.jpT.Cm(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + str2 + " AND status >= 0" + str3 + ";", new Object[]{aVar.aPU(), aVar.aPU(), aVar.aPV(), aVar.aPU(), aVar.aPV(), aVar.aPV(), u}));
        HashMap hashMap = new HashMap();
        while (Cm.moveToNext()) {
            m k = new m().k(Cm);
            if (!this.jsj.jst.contains(k.jrv)) {
                l lVar = (l) hashMap.get(Long.valueOf(k.jsA));
                if (lVar == null || d.c(c.jqv, k.jru, lVar.jru) < 0) {
                    k.aQc();
                    hashMap.put(Long.valueOf(k.jsA), k);
                }
            }
        }
        Cm.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        jVar.jsx = new ArrayList();
        jVar.jsx.addAll(hashMap.values());
        if (this.jsj.jsu != null) {
            Collections.sort(jVar.jsx, this.jsj.jsu);
        }
    }

    public final String getName() {
        return "FTS5SearchFriendLogic.NormalSearchTask";
    }
}
