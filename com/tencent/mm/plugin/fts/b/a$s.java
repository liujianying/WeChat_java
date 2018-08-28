package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class a$s extends h {
    final /* synthetic */ a jtJ;

    public a$s(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        jVar.jrx = g.ax(this.jsj.bWm, true);
        a a = a.a(this.jtJ);
        g gVar = jVar.jrx;
        int[] iArr = this.jsj.jsq;
        String aQa = gVar.aQa();
        long currentTimeMillis = System.currentTimeMillis() - 1105032704;
        long size = (long) gVar.jrZ.size();
        String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.l(iArr) + " ORDER BY Rank ;", new Object[]{a.aPU(), a.aPV(), Long.valueOf(size), a.aPV(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.aPU(), a.aPV(), a.aPU(), a.aPV(), a.aPV(), aQa});
        Cursor rawQuery = a.jpT.rawQuery(format, new String[]{gVar.jrW});
        List<m> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.jsj.jst);
        long j = 0;
        while (rawQuery.moveToNext()) {
            m j2 = new m().j(rawQuery);
            if (hashSet.add(j2.jrv)) {
                if (j < j2.jsI) {
                    if (arrayList.size() > this.jsj.jss) {
                        break;
                    }
                    j = j2.jsI;
                    arrayList.add(j2);
                } else {
                    arrayList.add(j2);
                }
                if (Thread.interrupted()) {
                    rawQuery.close();
                    throw new InterruptedException("Task is Cancel: " + this.jsj.bWm);
                }
            }
        }
        rawQuery.close();
        jVar.jsx = new ArrayList();
        for (m mVar : arrayList) {
            mVar.aQc();
            mVar.a(jVar.jrx);
            jVar.jsx.add(mVar);
        }
        if (this.jsj.jsu != null) {
            Collections.sort(jVar.jsx, this.jsj.jsu);
        }
    }

    public final String getName() {
        return "SearchTopContactInnerRankTask";
    }

    public final int getId() {
        return 26;
    }
}
