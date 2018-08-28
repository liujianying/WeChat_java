package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.HashSet;

class b$f extends h {
    final /* synthetic */ b iXs;

    b$f(b bVar, i iVar) {
        this.iXs = bVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        jVar.jrx = g.ax(this.jsj.bWm, true);
        a aVar = this.iXs.iXp;
        int i = this.jsj.jss + 1;
        String aQa = jVar.jrx.aQa();
        Cursor rawQuery = aVar.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1) + ";", new Object[]{aVar.aPU(), aVar.aPU(), aVar.aPV(), aVar.aPU(), aVar.aPV(), aVar.aPV(), aQa}), null);
        jVar.jsx = new ArrayList();
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                jVar.jsx.add(new m().k(rawQuery));
                if (jVar.jsx.size() > this.jsj.jss) {
                    break;
                } else if (Thread.interrupted()) {
                    rawQuery.close();
                    throw new InterruptedException();
                }
            }
        }
        rawQuery.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public final String getName() {
        return "SearchTopFavoriteTask";
    }

    public final int getId() {
        return 9;
    }
}
