package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private m dhW;
    com.tencent.mm.plugin.fts.c.d juL;

    public class b extends a {
        public final boolean execute() {
            d.this.juL.jpT.execSQL(String.format("DELETE FROM %s ;", new Object[]{"FTS5MetaSOSHistory"}));
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class d extends h {
        public d(i iVar) {
            super(iVar);
        }

        protected final void a(j jVar) {
            Cursor rawQuery;
            super.a(jVar);
            jVar.jsx = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = d.this.juL;
            String str = this.jsj.bWm;
            int i = this.jsj.jss;
            if (str.trim().length() > 0) {
                str = com.tencent.mm.plugin.fts.a.d.u(new String[]{str});
                rawQuery = dVar.jpT.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT " + i, new Object[]{"FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5IndexSOSHistory", str}), null);
            } else {
                rawQuery = dVar.jpT.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT " + i, new Object[]{"FTS5MetaSOSHistory"}), null);
            }
            while (rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.content = str;
                jVar.jsx.add(mVar);
            }
            rawQuery.close();
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.juL = (com.tencent.mm.plugin.fts.c.d) ((n) g.n(n.class)).getFTSIndexStorage(1024);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        return false;
    }

    public final void addSOSHistory(String str) {
        a aVar = new a(this);
        aVar.juM = str;
        this.dhW.a(132072, aVar);
    }

    public final void deleteSOSHistory() {
        this.dhW.a(132072, new b());
    }

    public final void deleteSOSHistory(String str) {
        c cVar = new c(this);
        cVar.juM = str;
        this.dhW.a(132072, cVar);
    }

    public final a a(i iVar) {
        d dVar = new d(iVar);
        this.dhW.a(-65536, dVar);
        return dVar;
    }

    protected final boolean BT() {
        this.juL = null;
        this.dhW = null;
        return true;
    }
}
