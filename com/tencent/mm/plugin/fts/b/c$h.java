package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.a;
import com.tencent.mm.plugin.fts.c.c;
import java.util.ArrayList;

class c$h extends h {
    final /* synthetic */ c jux;

    c$h(c cVar, i iVar) {
        this.jux = cVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        CA("start");
        jVar.jrx = g.a(this.jsj.bWm, false, this.jux.juw);
        c cVar = this.jux.jup;
        g gVar = jVar.jrx;
        String str = this.jsj.jso;
        String aQa = gVar.aQa();
        aQa = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[]{cVar.aPU(), cVar.aPU(), cVar.aPV(), cVar.aPU(), cVar.aPV(), cVar.aPV(), aQa});
        Cursor rawQuery = cVar.jpT.rawQuery(aQa, new String[]{str});
        jVar.jsx = new ArrayList();
        while (rawQuery.moveToNext()) {
            jVar.jsx.add(new m().i(rawQuery));
        }
        rawQuery.close();
        CA("findConversationMessage");
        if (jVar.jrx.jrY.length > 1) {
            rawQuery = ((a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3)).a(g.ax(jVar.jrx.jrY[0], true), null, com.tencent.mm.plugin.fts.a.c.jql, com.tencent.mm.plugin.fts.a.c.jqp);
            if (rawQuery.moveToNext()) {
                l lVar = new l();
                lVar.jrv = "create_talker_message​";
                jVar.jsx.add(0, lVar);
            }
            rawQuery.close();
            CA("findTalkerConversation");
        }
    }

    public final String getName() {
        return "SearchConversationMessageTask";
    }

    public final int getId() {
        return 14;
    }
}
