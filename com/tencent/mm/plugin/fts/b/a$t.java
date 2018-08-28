package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class a$t extends h {
    final /* synthetic */ a jtJ;

    public a$t(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        int i = 0;
        jVar.jrx = g.ax(this.jsj.bWm, true);
        a a = a.a(this.jtJ);
        g gVar = jVar.jrx;
        String aQa = gVar.aQa();
        long size = (long) gVar.jrZ.size();
        long currentTimeMillis = System.currentTimeMillis() - 1105032704;
        Cursor rawQuery = a.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{a.aPU(), a.aPV(), Long.valueOf(size), Long.valueOf(currentTimeMillis), a.aPU(), a.aPV(), a.aPU(), a.aPV(), a.aPV(), aQa}), null);
        List<m> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.jsj.jst);
        while (rawQuery.moveToNext()) {
            m k = new m().k(rawQuery);
            if (hashSet.add(k.jrv)) {
                if (i < k.jru) {
                    if (arrayList.size() > this.jsj.jss) {
                        break;
                    }
                    i = k.jru;
                    arrayList.add(k);
                } else {
                    arrayList.add(k);
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
        return "SearchTopContactTask";
    }

    public final int getId() {
        return 22;
    }
}
