package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class u$a extends SQLiteOpenHelper {
    final /* synthetic */ u aGE;

    u$a(u uVar, Context context, String str) {
        this.aGE = uVar;
        super(context, str, null, 1);
    }

    private boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query;
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        try {
            this.aGE.c("Error querying for table", str, e);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Set<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        Set c = c(sQLiteDatabase, "properties");
        String[] strArr = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};
        while (i < 6) {
            String str = strArr[i];
            if (c.remove(str)) {
                i++;
            } else {
                throw new SQLiteException("Database properties is missing required column: " + str);
            }
        }
        if (!c.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (u.a(this.aGE).Y(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                u.a(this.aGE).start();
                this.aGE.aS("Opening the database failed, dropping the table and recreating it");
                this.aGE.aFn.mContext.getDatabasePath(u.b(this.aGE)).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    u.a(this.aGE).aFD = 0;
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    this.aGE.g("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }
        throw new SQLiteException("Database open failed");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (ai.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        int i = 1;
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (b(sQLiteDatabase, "hits2")) {
            Set c = c(sQLiteDatabase, "hits2");
            String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
            int i2 = 0;
            while (i2 < 4) {
                String str = strArr[i2];
                if (c.remove(str)) {
                    i2++;
                } else {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            if (c.remove("hit_app_id")) {
                i = 0;
            }
            if (!c.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (i != 0) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            sQLiteDatabase.execSQL(u.nF());
        }
        if (b(sQLiteDatabase, "properties")) {
            c(sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
