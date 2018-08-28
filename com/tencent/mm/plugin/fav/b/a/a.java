package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement iXn;

    protected final void BR() {
        if (BS()) {
            this.jpT.t(-106, 4);
        }
        this.iXn = this.jpT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{aPU()}));
    }

    protected final boolean BS() {
        return !cE(-106, 4);
    }

    protected final String getTableName() {
        return "Favorite";
    }

    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    public final int getType() {
        return 256;
    }

    public final int getPriority() {
        return 256;
    }

    protected final String aLZ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[]{aPU()});
    }

    public final void a(int i, long j, String str, long j2, String str2, int i2) {
        String Cu = d.Cu(str2);
        if (!bi.oW(Cu)) {
            boolean inTransaction = this.jpT.inTransaction();
            if (!inTransaction) {
                this.jpT.beginTransaction();
            }
            try {
                this.jpU.bindString(1, Cu);
                this.jpU.execute();
                this.iXn.bindLong(1, 196608);
                this.iXn.bindLong(2, (long) i);
                this.iXn.bindLong(3, j);
                this.iXn.bindString(4, str);
                this.iXn.bindLong(5, j2);
                this.iXn.bindLong(6, (long) i2);
                this.iXn.execute();
                if (!inTransaction) {
                    this.jpT.commit();
                }
            } catch (SQLiteException e) {
                x.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(196608), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.jqb.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    x.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }
}
