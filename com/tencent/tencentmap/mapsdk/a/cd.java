package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class cd extends SQLiteOpenHelper {
    public static Object a = new Object();
    private static SQLiteDatabase c = null;
    private Context b;

    private cd(Context context) {
        super(context, "beacon_tmap_db", null, 22);
        this.b = context;
    }

    public static synchronized cd a(Context context) {
        cd cdVar;
        synchronized (cd.class) {
            cdVar = new cd(context);
        }
        return cdVar;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            if (sQLiteDatabase != null) {
                if (cc.a != null) {
                    for (Object[] objArr : cc.a) {
                        ct.g("table:%s", new Object[]{objArr[0]});
                        sQLiteDatabase.execSQL(objArr[1]);
                    }
                }
            }
        }
    }

    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ct.g("upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[]{"beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2)});
        if (a(sQLiteDatabase)) {
            ct.g("drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
        } else {
            ct.d("drop all fail try deleted file,may next time will success!", new Object[0]);
            File databasePath = this.b.getDatabasePath("beacon_tmap_db");
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e.a(this.b);
        if (Integer.parseInt(e.c()) >= 11) {
            ct.g("downgrade a db  [%s] from v %d to  v%d , deleted all tables!", new Object[]{"beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2)});
            if (a(sQLiteDatabase)) {
                ct.g("drop all success recreate!", new Object[0]);
                onCreate(sQLiteDatabase);
            } else {
                ct.d("drop all fail try deleted file,may next time will success!", new Object[0]);
                File databasePath = this.b.getDatabasePath("beacon_tmap_db");
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        boolean z;
        Cursor query;
        try {
            List<String> arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("sqlite_master", new String[]{"name"}, "type = 'table'", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        arrayList.add(query.getString(0));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ct.a(th);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            z = false;
                            return z;
                        } catch (Throwable th3) {
                            th = th3;
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            String str = "drop table if exists %s";
            if (arrayList.size() > 0) {
                for (String str2 : arrayList) {
                    if (!(str2.equals("sqlite_sequence") || str2.equals("android_metadata"))) {
                        sQLiteDatabase.execSQL(String.format(Locale.US, str, new Object[]{str2}));
                        ct.g("drop %s", new Object[]{str2});
                    }
                }
            }
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            z = true;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            throw th;
        }
        return z;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        synchronized (this) {
            while (c == null && i < 5) {
                i++;
                try {
                    c = super.getWritableDatabase();
                } catch (Exception e) {
                    ct.c("getWritableDatabase error count %d", new Object[]{Integer.valueOf(i)});
                    if (i == 5) {
                        ct.d("error get DB failed", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (Throwable e2) {
                        ct.a(e2);
                    }
                }
            }
            sQLiteDatabase = c;
        }
        return sQLiteDatabase;
    }
}
