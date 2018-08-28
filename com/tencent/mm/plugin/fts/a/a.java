package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bt.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class a implements i {
    private volatile boolean isCreated;
    private boolean jpR;
    private f<String, String> jpS;
    public volatile h jpT;
    public SQLiteStatement jpU;
    private SQLiteStatement jpV;
    private SQLiteStatement jpW;
    private SQLiteStatement jpX;
    private SQLiteStatement jpY;
    public SQLiteStatement jpZ;
    private SQLiteStatement jqa;
    public SQLiteStatement jqb;

    public abstract void BR();

    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        if (getPriority() < iVar.getPriority()) {
            return -1;
        }
        return getPriority() > iVar.getPriority() ? 1 : 0;
    }

    public a() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", new Object[]{getName()});
    }

    public final synchronized void create() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.isCreated)});
        if (!this.isCreated) {
            Object obj;
            if (((n) g.n(n.class)).isFTSContextReady()) {
                this.jpT = ((n) g.n(n.class)).getFTSIndexDB();
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", new Object[]{aPV(), aPU(), getTableName()});
                if (this.jpT.Cn(aPV()) && this.jpT.Cn(r1) && !BS()) {
                    x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                } else {
                    x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r0});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r1});
                    this.jpT.execSQL(format);
                    this.jpT.execSQL(format2);
                    this.jpT.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{aPV()}));
                    this.jpT.execSQL(aLZ());
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[]{r1, r1}));
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", new Object[]{r1, r1}));
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", new Object[]{r1, r1}));
                    this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{r1, r1}));
                }
                this.jpU = this.jpT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{r0}));
                this.jpV = this.jpT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{r1}));
                this.jpW = this.jpT.compileStatement(String.format("DELETE FROM %s WHERE rowid=?;", new Object[]{r0}));
                this.jpX = this.jpT.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r1}));
                this.jpY = this.jpT.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[]{r1}));
                this.jpZ = this.jpT.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", new Object[]{r1}));
                this.jqa = this.jpT.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", new Object[]{r1}));
                this.jqb = this.jpT.compileStatement("SELECT mm_last_error();");
                this.jpS = new f(100);
                BR();
                int obj2 = 1;
            } else {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                obj2 = null;
            }
            if (obj2 != null) {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.isCreated = true;
            }
        }
    }

    public String getTableName() {
        return "Common";
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2) {
        String Cu = d.Cu(str2);
        if (!bi.oW(Cu)) {
            boolean inTransaction = this.jpT.inTransaction();
            if (!inTransaction) {
                this.jpT.beginTransaction();
            }
            try {
                this.jpU.bindString(1, Cu);
                this.jpU.execute();
                this.jpV.bindLong(1, (long) i);
                this.jpV.bindLong(2, (long) i2);
                this.jpV.bindLong(3, j);
                this.jpV.bindString(4, str);
                this.jpV.bindLong(5, j2);
                this.jpV.execute();
                if (!inTransaction) {
                    this.jpT.commit();
                }
                if (aPW()) {
                    this.jpS.put(bq(str, i2), Cu);
                }
            } catch (SQLiteException e) {
                x.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.jqb.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    x.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }

    private static String bq(String str, int i) {
        return str + "​" + i;
    }

    public final void b(int[] iArr, String str) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.l(iArr) + " AND aux_index=?;", new Object[]{aPU()});
        Cursor rawQuery = this.jpT.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bi(arrayList);
    }

    public final void k(int[] iArr) {
        List arrayList = new ArrayList(2048);
        Cursor rawQuery = this.jpT.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + d.l(iArr) + ";", new Object[]{aPU()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bi(arrayList);
    }

    public final void b(int[] iArr, long j) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.l(iArr) + " AND entity_id=?;", new Object[]{aPU()});
        Cursor rawQuery = this.jpT.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bi(arrayList);
    }

    public final void bi(List<Long> list) {
        boolean inTransaction = this.jpT.inTransaction();
        if (!inTransaction) {
            this.jpT.beginTransaction();
        }
        for (Long longValue : list) {
            this.jpW.bindLong(1, longValue.longValue());
            this.jpW.execute();
        }
        for (Long longValue2 : list) {
            this.jpX.bindLong(1, longValue2.longValue());
            this.jpX.execute();
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void D(String str, long j) {
        this.jqa.bindLong(1, j);
        this.jqa.bindString(2, str);
        this.jqa.execute();
    }

    public final void g(Long l) {
        boolean inTransaction = this.jpT.inTransaction();
        if (!inTransaction) {
            this.jpT.beginTransaction();
        }
        this.jpW.bindLong(1, l.longValue());
        this.jpW.execute();
        this.jpX.bindLong(1, l.longValue());
        this.jpX.execute();
        if (!inTransaction) {
            commit();
        }
    }

    public final void g(List<Long> list, int i) {
        boolean inTransaction = this.jpT.inTransaction();
        if (!inTransaction) {
            this.jpT.beginTransaction();
        }
        this.jpY.bindLong(1, (long) i);
        for (Long longValue : list) {
            this.jpY.bindLong(2, longValue.longValue());
            this.jpY.execute();
        }
        if (!inTransaction) {
            this.jpT.commit();
        }
    }

    public final List<Long> c(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.l(iArr) + ";", new Object[]{aPU()});
        Cursor rawQuery = this.jpT.rawQuery(format, new String[]{str});
        List<Long> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        g(arrayList, 1);
        return arrayList;
    }

    public final List<b> e(int[] iArr, int i) {
        Cursor rawQuery = this.jpT.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.l(iArr) + ";", new Object[]{aPU()}), null);
        List<b> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.jrt = rawQuery.getLong(0);
            bVar.type = rawQuery.getInt(1);
            bVar.jru = rawQuery.getInt(2);
            bVar.jrv = rawQuery.getString(3);
            arrayList.add(bVar);
            arrayList2.add(Long.valueOf(bVar.jrt));
        }
        rawQuery.close();
        g(arrayList2, i);
        return arrayList;
    }

    public final Cursor a(com.tencent.mm.plugin.fts.a.a.g gVar, int[] iArr, int[] iArr2, boolean z, boolean z2) {
        String aQa = gVar.aQa();
        String format = z ? String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{aPV(), Integer.valueOf(gVar.jrZ.size())}) : "";
        String str = "";
        String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.l(iArr2);
        String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.l(iArr);
        return this.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{aPU(), aPU(), aPV(), aPU(), aPV(), aPV(), aQa}), null);
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return d.cnR();
        }
        if (iArr == null || iArr.length == 0) {
            return d.cnR();
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        if (z) {
            stringBuilder.append("docid,");
        }
        if (z2) {
            stringBuilder.append("entity_id,");
        }
        if (z3) {
            stringBuilder.append("aux_index,");
        }
        if (z4) {
            stringBuilder.append("timestamp,");
        }
        if (z5) {
            stringBuilder.append("status,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return this.jpT.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + d.l(iArr) + ";", new Object[]{stringBuilder2, aPU()}), null);
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.jpR), Boolean.valueOf(this.isCreated)});
        if (!this.jpR && this.isCreated && BT()) {
            x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.jpR = true;
        }
    }

    public boolean BT() {
        this.jpT = null;
        this.jpU.close();
        this.jpV.close();
        this.jpW.close();
        this.jpX.close();
        this.jpY.close();
        this.jqb.close();
        if (this.jpS != null) {
            this.jpS.clear();
        }
        return true;
    }

    public final String aPU() {
        return "FTS5Meta" + getTableName();
    }

    public final String aPV() {
        return "FTS5Index" + getTableName();
    }

    public final void beginTransaction() {
        this.jpT.beginTransaction();
    }

    public final void commit() {
        this.jpT.commit();
    }

    public final void t(long j, long j2) {
        this.jpT.t(j, j2);
    }

    public final boolean cE(int i, int i2) {
        return this.jpT.cE(i, i2);
    }

    public String aLZ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{aPU()});
    }

    public boolean BS() {
        return false;
    }

    public final String br(String str, int i) {
        String bq;
        if (aPW()) {
            bq = bq(str, i);
            if (this.jpS.bb(bq)) {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
                return (String) this.jpS.get(bq);
            }
        }
        bq = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[]{aPU(), aPV(), aPU(), aPV()});
        Cursor rawQuery = this.jpT.rawQuery(bq, new String[]{str, String.valueOf(i)});
        bq = null;
        if (rawQuery.moveToFirst()) {
            bq = rawQuery.getString(0);
        }
        rawQuery.close();
        return bq;
    }

    public boolean aPW() {
        return false;
    }

    public final void Cs(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : this.jpS.map.keySet()) {
            if (str2.startsWith(str)) {
                hashSet.add(str2);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.jpS.remove((String) it.next());
        }
    }
}
