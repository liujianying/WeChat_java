package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.ArrayList;

public class a$p extends h {
    final /* synthetic */ a jtJ;

    public a$p(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        long longValue = Long.valueOf(this.jsj.bWm).longValue();
        Cursor rawQuery = r2.jpT.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{a.a(this.jtJ).aPU(), Long.valueOf(longValue), Integer.valueOf(131072)}), null);
        jVar.jsx = new ArrayList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.jrv = rawQuery.getString(0);
            jVar.jsx.add(lVar);
        }
        rawQuery.close();
    }

    public final String getName() {
        return "SearchContactSmallerTimestampTask";
    }
}
