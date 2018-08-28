package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class a$r extends h {
    final /* synthetic */ a jtJ;

    public a$r(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        CA("start");
        jVar.jrx = g.ax(this.jsj.bWm, true);
        a a = a.a(this.jtJ);
        g gVar = jVar.jrx;
        String aQa = gVar.aQa();
        long currentTimeMillis = System.currentTimeMillis() - 1209600000;
        long size = (long) gVar.jrZ.size();
        aQa = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[]{a.aPU(), a.aPV(), Long.valueOf(size), a.aPV(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.aPU(), a.aPV(), a.aPU(), a.aPV(), a.aPV(), aQa});
        Cursor rawQuery = a.jpT.rawQuery(aQa, new String[]{gVar.jrW});
        List<m> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.jsj.jst);
        while (rawQuery.moveToNext()) {
            m j = new m().j(rawQuery);
            if (hashSet.add(j.jrv)) {
                if (arrayList.size() > this.jsj.jss) {
                    break;
                }
                arrayList.add(j);
                if (Thread.interrupted()) {
                    rawQuery.close();
                    throw new InterruptedException("Task is Cancel: " + this.jsj.bWm);
                }
            }
        }
        rawQuery.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        CA("orm");
        jVar.jsx = new ArrayList(arrayList.size());
        for (m mVar : arrayList) {
            mVar.aQc();
            mVar.a(jVar.jrx);
            jVar.jsx.add(mVar);
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.jsj.jsu != null) {
            Collections.sort(jVar.jsx, this.jsj.jsu);
        }
        CA("calOffsets");
        if (jVar.jrx.jrZ.size() > 1 && a.a(this.jtJ).b(jVar.jrx)) {
            l lVar = new l();
            lVar.jrv = "create_chatroom​";
            if (jVar.jsx.size() > 3) {
                jVar.jsx.add(3, lVar);
            } else {
                jVar.jsx.add(lVar);
            }
        }
        CA("checkChatroom");
    }

    public final String getName() {
        return "SearchTopChatroomInnerRankTask";
    }

    public final int getId() {
        return 25;
    }
}
