package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;

public class d$a extends a {
    public String juM;
    final /* synthetic */ d juN;

    public d$a(d dVar) {
        this.juN = dVar;
    }

    public final boolean execute() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.juM);
        stringBuffer.append("​");
        stringBuffer.append(d.av(this.juM, false));
        stringBuffer.append("​");
        stringBuffer.append(d.av(this.juM, true));
        com.tencent.mm.plugin.fts.c.d dVar = this.juN.juL;
        String str = this.juM;
        String stringBuffer2 = stringBuffer.toString();
        Cursor rawQuery = dVar.jpT.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
        long j = -1;
        if (rawQuery.moveToNext()) {
            j = rawQuery.getLong(0);
        }
        rawQuery.close();
        if (j >= 0) {
            dVar.jvl.bindLong(1, System.currentTimeMillis());
            dVar.jvl.bindLong(2, j);
            dVar.jvl.execute();
        } else {
            if (!dVar.jpT.inTransaction()) {
                dVar.jpT.beginTransaction();
            }
            dVar.jpU.bindString(1, stringBuffer2);
            dVar.jpU.execute();
            dVar.jpV.bindString(1, str);
            dVar.jpV.bindLong(2, System.currentTimeMillis());
            dVar.jpV.execute();
            if (dVar.jpT.inTransaction()) {
                dVar.jpT.commit();
            }
        }
        return true;
    }

    public final String getName() {
        return "AddSOSHistoryTask";
    }
}
