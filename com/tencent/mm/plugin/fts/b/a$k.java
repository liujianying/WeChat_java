package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;

class a$k extends h {
    final /* synthetic */ a jtJ;

    public a$k(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        super.a(jVar);
        a a = a.a(this.jtJ);
        String str = this.jsj.bWm;
        String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{a.aPU()});
        Cursor rawQuery = a.jpT.rawQuery(format, new String[]{str});
        jVar.jsx = new ArrayList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.jrv = rawQuery.getString(0);
            jVar.jsx.add(lVar);
        }
        rawQuery.close();
        jVar.bjW = 0;
    }

    public final String getName() {
        return "SearchChatroomByMemberTask";
    }
}
