package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import java.util.ArrayList;
import java.util.List;

class a$f extends a {
    final /* synthetic */ a jtJ;
    private int jtY;
    private int jtZ;

    private a$f(a aVar) {
        this.jtJ = aVar;
        this.jtY = 0;
        this.jtZ = 0;
    }

    /* synthetic */ a$f(a aVar, byte b) {
        this(aVar);
    }

    public final boolean execute() {
        Cursor rawQuery = a.a(this.jtJ).jpT.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(0);
            long j = rawQuery.getLong(1);
            List list = (List) a.g(this.jtJ).get(string);
            if (list == null) {
                list = new ArrayList(16);
                a.g(this.jtJ).put(string, list);
                this.jtY++;
            }
            list.add(Long.valueOf(j));
            this.jtZ++;
        }
        rawQuery.close();
        return true;
    }

    public final String afC() {
        return String.format("{users: %d labels: %d}", new Object[]{Integer.valueOf(this.jtY), Integer.valueOf(this.jtZ)});
    }

    public final String getName() {
        return "LoadLabelCacheTask";
    }
}
