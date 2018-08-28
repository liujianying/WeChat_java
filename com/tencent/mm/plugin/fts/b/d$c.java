package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.c.d;

public class d$c extends a {
    public String juM;
    final /* synthetic */ d juN;

    public d$c(d dVar) {
        this.juN = dVar;
    }

    public final boolean execute() {
        d dVar = this.juN.juL;
        String str = this.juM;
        dVar.jpT.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
        return true;
    }

    public final String getName() {
        return "DeleteSOSHistoryTask";
    }
}
