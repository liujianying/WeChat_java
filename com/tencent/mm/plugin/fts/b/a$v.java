package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Iterator;

class a$v extends a {
    final /* synthetic */ a jtJ;
    private long jui;
    private int juj = 0;

    public a$v(a aVar, long j) {
        this.jtJ = aVar;
        this.jui = j;
    }

    public final boolean execute() {
        ArrayList arrayList = new ArrayList(32);
        com.tencent.mm.plugin.fts.c.a a = a.a(this.jtJ);
        long j = this.jui;
        Cursor rawQuery = a.jpT.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(0));
        }
        rawQuery.close();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!a.b(this.jtJ).containsKey(str)) {
                a.b(this.jtJ).put(str, a.a(this.jtJ).c(c.jql, str));
            }
        }
        return true;
    }

    public final String afC() {
        return String.format("{mLabelId: %d mContactCount: %d}", new Object[]{Long.valueOf(this.jui), Integer.valueOf(this.juj)});
    }

    public final String getName() {
        return "UpdateLabelTask";
    }
}
