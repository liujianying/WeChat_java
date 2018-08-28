package com.tencent.mm.plugin.fts.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements i {
    private boolean isCreated;
    private boolean jpR;
    public h jpT;
    public SQLiteStatement jpU;
    public SQLiteStatement jpV;
    public SQLiteStatement jvl;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public d() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[]{"FTS5SOSHistoryStorage"});
    }

    public final void create() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.isCreated)});
        if (!this.isCreated) {
            int i;
            if (((n) g.n(n.class)).isFTSContextReady()) {
                this.jpT = ((n) g.n(n.class)).getFTSIndexDB();
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.jpT.Cn("FTS5IndexSOSHistory") && this.jpT.Cn("FTS5MetaSOSHistory")) {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{"FTS5IndexSOSHistory"});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{"FTS5MetaSOSHistory"});
                    this.jpT.execSQL(format);
                    this.jpT.execSQL(format2);
                    this.jpT.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{"FTS5IndexSOSHistory"}));
                    this.jpT.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[]{"FTS5MetaSOSHistory"}));
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[]{"FTS5MetaSOSHistory"}));
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[]{"FTS5MetaSOSHistory"}));
                }
                this.jpU = this.jpT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{"FTS5IndexSOSHistory"}));
                this.jpV = this.jpT.compileStatement(String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[]{"FTS5MetaSOSHistory"}));
                this.jvl = this.jpT.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[]{"FTS5MetaSOSHistory"}));
                boolean i2 = true;
            } else {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i2 = 0;
            }
            if (i2 != 0) {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.isCreated = true;
            }
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.jpR), Boolean.valueOf(this.isCreated)});
        if (!this.jpR && this.isCreated) {
            this.jpU.close();
            this.jvl.close();
            this.jpV.close();
            x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.jpR = true;
        }
    }

    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    public final int getType() {
        return 1024;
    }

    public final int getPriority() {
        return 1024;
    }

    public final String br(String str, int i) {
        return null;
    }
}
