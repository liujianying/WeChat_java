package com.tencent.sqlitelint.behaviour.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.sqlitelint.util.SLog;

public enum c {
    ;
    
    private volatile a vnT;

    private static final class a extends SQLiteOpenHelper {
        a(Context context) {
            super(context, "SQLiteLintInternal.db", null, 1);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            SLog.i("SQLiteLint.SQLiteLintOwnDatabase", "onCreate", new Object[0]);
            sQLiteDatabase.execSQL(a.vnP);
            while (i < a.vnQ.length) {
                sQLiteDatabase.execSQL(a.vnQ[i]);
                i++;
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private c(String str) {
    }

    public final SQLiteDatabase getDatabase() {
        if (this.vnT != null) {
            return this.vnT.getWritableDatabase();
        }
        throw new IllegalStateException("getIssueStorage db not ready");
    }

    public final void initialize(Context context) {
        if (this.vnT == null) {
            synchronized (this) {
                if (this.vnT == null) {
                    this.vnT = new a(context);
                }
            }
        }
    }
}
