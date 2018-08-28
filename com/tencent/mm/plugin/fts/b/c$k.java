package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.a;
import com.tencent.mm.plugin.fts.c.c;
import java.util.LinkedList;

class c$k extends h {
    private int juJ = 0;
    private int juK = 0;
    final /* synthetic */ c jux;

    public c$k(c cVar, i iVar) {
        this.jux = cVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        CA("start");
        jVar.jrx = g.a(this.jsj.bWm, false, this.jux.juw);
        c cVar = this.jux.jup;
        g gVar = jVar.jrx;
        int i = this.jsj.jss;
        String aQa = gVar.aQa();
        Cursor rawQuery = cVar.jpT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i != Integer.MAX_VALUE ? " LIMIT " + (i + 1) : "") + ";", new Object[]{cVar.aPU(), cVar.aPV(), cVar.aPU(), cVar.aPV(), cVar.aPV(), aQa}), null);
        jVar.jsx = new LinkedList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.type = rawQuery.getInt(0);
            lVar.jru = rawQuery.getInt(1);
            lVar.jsA = rawQuery.getLong(2);
            lVar.jrv = rawQuery.getString(3);
            lVar.timestamp = rawQuery.getLong(4);
            lVar.userData = Integer.valueOf(rawQuery.getInt(5));
            jVar.jsx.add(lVar);
            this.juJ = ((Integer) lVar.userData).intValue() + this.juJ;
            this.juK++;
        }
        rawQuery.close();
        CA("groupMessage");
        if (jVar.jrx.jrY.length > 1) {
            Cursor a = ((a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3)).a(g.ax(jVar.jrx.jrY[0], true), null, com.tencent.mm.plugin.fts.a.c.jql, com.tencent.mm.plugin.fts.a.c.jqp);
            if (a.moveToNext()) {
                l lVar2 = new l();
                lVar2.jrv = "create_talker_message​";
                jVar.jsx.add(0, lVar2);
            }
            a.close();
            CA("findTalkerConversation");
        }
    }

    public final String afC() {
        return String.format("{totalMsgCount: %d conversationCount: %d}", new Object[]{Integer.valueOf(this.juJ), Integer.valueOf(this.juK)});
    }

    public final String getName() {
        return "SearchTopGroupMessageTask";
    }

    public final int getId() {
        return 15;
    }
}
