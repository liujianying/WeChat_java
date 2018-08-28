package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a$o extends h {
    final /* synthetic */ a jtJ;

    public a$o(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        List F = bi.F(this.jsj.bWm.split(","));
        a a = a.a(this.jtJ);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("member IN (");
        for (int i = 0; i < F.size(); i++) {
            stringBuffer.append("'");
            stringBuffer.append((String) F.get(i));
            stringBuffer.append("'");
            if (i != F.size() - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(")");
        Cursor rawQuery = a.jpT.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[]{a.aPU(), stringBuffer.toString()}), null);
        HashMap hashMap = new HashMap();
        while (rawQuery.moveToNext()) {
            List list;
            String string = rawQuery.getString(0);
            if (hashMap.containsKey(string)) {
                list = (List) hashMap.get(string);
            } else {
                list = new ArrayList();
            }
            l lVar = new l();
            lVar.jrv = rawQuery.getString(1);
            lVar.jsA = rawQuery.getLong(2);
            list.add(lVar);
            hashMap.put(string, list);
        }
        rawQuery.close();
        jVar.jsx = new ArrayList();
        l lVar2 = new l();
        lVar2.userData = hashMap;
        jVar.jsx.add(lVar2);
    }

    public final String getName() {
        return "SearchCommonChatroomTask";
    }
}
