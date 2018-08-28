package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.c.e;
import java.util.LinkedList;

class e$a extends a {
    int juQ;
    int juR;
    final /* synthetic */ e juS;

    private e$a(e eVar) {
        this.juS = eVar;
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final boolean execute() {
        this.juR = this.juS.juO.aQv();
        long currentTimeMillis = System.currentTimeMillis() - 5184000000L;
        e eVar = this.juS.juO;
        String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[]{eVar.aPU()});
        Cursor rawQuery = eVar.jpT.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
        Object linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            linkedList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        eVar.bi(linkedList);
        this.juQ = linkedList.size();
        return true;
    }

    public final String afC() {
        return String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[]{Integer.valueOf(this.juR), Integer.valueOf(this.juQ)});
    }

    public final String getName() {
        return "BuildTopHitsIndexTask";
    }
}
