package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.HashSet;

class a$m extends h {
    final /* synthetic */ a jtJ;

    public a$m(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        super.a(jVar);
        a a = a.a(this.jtJ);
        String str = this.jsj.jso;
        String u = d.u(jVar.jrx.jrX);
        Cursor rawQuery = a.jpT.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{a.aPV(), a.aPU(), a.aPV(), a.aPV(), u}), new String[]{str, u});
        HashSet hashSet = new HashSet();
        jVar.jsx = new ArrayList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.jrv = rawQuery.getString(0);
            if (hashSet.add(lVar.jrv)) {
                jVar.jsx.add(lVar);
            }
        }
        rawQuery.close();
        jVar.bjW = 0;
    }

    public final String getName() {
        return "SearchChatroomInMemberTask";
    }
}
