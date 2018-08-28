package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class d implements h {
    private SQLiteDatabase jpb;
    private SQLiteStatement jpc;
    private SQLiteStatement jpd;
    private SQLiteStatement jpe;

    public d(String str) {
        x.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[]{str});
        if (this.jpb != null) {
            x.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.jpb.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        this.jpb = SQLiteDatabase.openOrCreateDatabase(absolutePath, null);
        String zy = q.zy();
        g.Ek();
        g.Eg();
        byte[] v = com.tencent.mm.a.g.v((zy + ((long) a.Df())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.jpb;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, v);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.jpb.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.jpb.execSQL("PRAGMA synchronous=NORMAL;");
        this.jpb.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.jpc = this.jpb.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.jpd = this.jpb.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.jpe = this.jpb.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
        e.u(18, System.currentTimeMillis() - currentTimeMillis);
        x.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s", new Object[]{Long.valueOf(r4 - currentTimeMillis), bi.gc((long) absolutePath.length())});
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.jpb.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
    }

    public final Cursor Cm(String str) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.jpb.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
    }

    public final SQLiteStatement compileStatement(String str) {
        x.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[]{str});
        return this.jpb.compileStatement(str);
    }

    public final boolean cE(int i, int i2) {
        int i3;
        if (!Cn("FTS5IndexVersion") || this.jpc == null) {
            i3 = 0;
        } else {
            i3 = (int) s((long) i, 0);
        }
        x.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final long s(long j, long j2) {
        this.jpc.bindLong(1, j);
        try {
            return this.jpc.simpleQueryForLong();
        } catch (SQLiteDoneException e) {
            return j2;
        }
    }

    public final void t(long j, long j2) {
        this.jpd.bindLong(1, j);
        this.jpd.bindLong(2, j2);
        this.jpd.execute();
    }

    public final boolean Cn(String str) {
        com.tencent.wcdb.Cursor rawQuery = this.jpb.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    public final void execSQL(String str) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.jpb.execSQL(str);
    }

    public final void execSQL(String str, Object[] objArr) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.jpb.execSQL(str, objArr);
    }

    public final void close() {
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.jpb;
        objArr[1] = Boolean.valueOf(this.jpb == null ? false : this.jpb.isOpen());
        x.w(str, str2, objArr);
        if (this.jpb != null && this.jpb.isOpen()) {
            x.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[]{Boolean.valueOf(this.jpb.inTransaction())});
            while (this.jpb.inTransaction()) {
                this.jpb.endTransaction();
            }
            this.jpc.close();
            this.jpd.close();
            this.jpb.close();
            this.jpb = null;
        }
    }

    public final synchronized void beginTransaction() {
        if (!(this.jpb == null || this.jpb.inTransaction())) {
            this.jpb.beginTransaction();
        }
    }

    public final boolean inTransaction() {
        if (this.jpb == null || !this.jpb.inTransaction()) {
            return false;
        }
        return true;
    }

    public final synchronized void commit() {
        if (this.jpb != null && this.jpb.inTransaction()) {
            this.jpb.setTransactionSuccessful();
            this.jpb.endTransaction();
        }
    }

    public final synchronized void rollback() {
        if (this.jpb != null && this.jpb.isOpen() && this.jpb.inTransaction()) {
            x.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.jpb.endTransaction();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", new Object[]{e});
            }
        }
        return;
    }

    protected static final void aPR() {
        g.Ek();
        new File(g.Ei().cachePath, "FTS5IndexMicroMsg.db").delete();
    }

    public static final File aPS() {
        g.Ek();
        return new File(g.Ei().cachePath, "FTS5IndexMicroMsg.db");
    }
}
