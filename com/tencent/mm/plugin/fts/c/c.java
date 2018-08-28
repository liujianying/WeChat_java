package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class c extends a {
    public SQLiteStatement jvj;
    private SQLiteStatement jvk;

    protected final void BR() {
        if (BS()) {
            this.jpT.t(-105, 3);
            this.jpT.t(-200, Long.MAX_VALUE);
        }
        this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{aPU(), aPU()}));
        this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[]{aPU(), aPU()}));
        this.jvj = this.jpT.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[]{aPU()}));
        this.jvk = this.jpT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{aPU()}));
    }

    protected final boolean BT() {
        this.jvj.close();
        this.jvk.close();
        return super.BT();
    }

    protected final String getTableName() {
        return "Message";
    }

    public final String getName() {
        return "FTS5MessageStorage";
    }

    public final int getType() {
        return 4;
    }

    public final int getPriority() {
        return 4;
    }

    public final void a(int[] iArr, long j, long j2) {
        List arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.l(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{aPU()});
        Cursor rawQuery = this.jpT.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bi(arrayList);
    }

    public final Cursor a(g gVar, String str, Set<String> set) {
        String str2;
        String aQa = gVar.aQa();
        String str3 = "";
        if (bi.oW(str)) {
            str2 = str3;
        } else {
            str2 = String.format(" AND aux_index = '%s'", new Object[]{str});
        }
        String str4 = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (String str32 : set) {
            stringBuffer.append("'");
            stringBuffer.append(str32);
            stringBuffer.append("'");
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            str32 = " AND talker IN (" + stringBuffer.substring(0, stringBuffer.length() - 1) + ")";
        } else {
            str32 = str4;
        }
        return this.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str32 + str2 + " AND status >= 0;", new Object[]{aPU(), aPU(), aPV(), aPU(), aPV(), aPV(), aQa}), null);
    }

    public final Cursor a(g gVar, List<String> list) {
        String aQa = gVar.aQa();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        String str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        return this.jpT.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[]{Integer.valueOf(list.size()), aPU(), aPV(), aPU(), aPV(), aPV(), aQa, str2}), null);
    }

    protected final boolean BS() {
        return !cE(-105, 3);
    }

    protected final String aLZ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[]{aPU()});
    }

    public final void a(int i, long j, String str, long j2, String str2, String str3) {
        try {
            this.jpU.bindString(1, str2);
            this.jpU.execute();
            this.jvk.bindLong(1, 65536);
            this.jvk.bindLong(2, (long) i);
            this.jvk.bindLong(3, j);
            this.jvk.bindString(4, str);
            this.jvk.bindLong(5, j2);
            this.jvk.bindString(6, str3);
            this.jvk.execute();
        } catch (SQLiteException e) {
            x.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(65536), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.jqb.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                x.e("MicroMsg.FTS.FTS5MessageStorage", ">> " + simpleQueryForString);
            }
            throw e;
        }
    }
}
