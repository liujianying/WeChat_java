package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

public interface h {
    Cursor Cm(String str);

    boolean Cn(String str);

    void beginTransaction();

    boolean cE(int i, int i2);

    void commit();

    SQLiteStatement compileStatement(String str);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);

    long s(long j, long j2);

    void t(long j, long j2);
}
