package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.util.Map;

public final class et extends SQLiteOpenHelper implements es {
    private static String a = "";
    private static et b;

    private et(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 5);
        try {
            context.deleteDatabase("access.db");
        } catch (Exception e) {
        }
    }

    public static et a() {
        if (b == null) {
            a = em.b() + "-access.db";
            b = new et(em.a(), a, null, 5);
        }
        return b;
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r10, com.tencent.tencentmap.mapsdk.a.eq.a r11, long r12) {
        /*
        r9 = this;
        r0 = 1;
        r1 = 0;
        monitor-enter(r9);
        r2 = r9.getWritableDatabase();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
    L_0x0007:
        r3 = r2.isDbLockedByOtherThreads();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        if (r3 != 0) goto L_0x0013;
    L_0x000d:
        r3 = r2.isDbLockedByCurrentThread();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        if (r3 == 0) goto L_0x001b;
    L_0x0013:
        r4 = 10;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0019 }
        goto L_0x0007;
    L_0x0019:
        r3 = move-exception;
        goto L_0x0007;
    L_0x001b:
        r3 = new android.content.ContentValues;	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.<init>();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "iplist";
        r5 = r11.d();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "schedule_lasttime";
        r6 = r11.b();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "apn_lasttime";
        r5 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "rule";
        r5 = r11.e();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "access_tbl";
        r5 = "apn=? and domain=?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r7 = 0;
        r6[r7] = r10;	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r7 = 1;
        r8 = r11.a();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = r2.update(r4, r3, r5, r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        if (r4 != 0) goto L_0x00ce;
    L_0x0065:
        r4 = "apn";
        r3.put(r4, r10);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "domain";
        r5 = r11.a();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "rule";
        r5 = r11.e();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "access_tbl";
        r5 = 0;
        r2 = r2.insert(r4, r5, r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = "DataAccessDBImpl";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = "insert record...ret:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = r5.append(r2);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = ",apnName:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = r5.append(r10);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = ",domain:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = r11.a();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = ",ip:";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r6 = r11.d();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r4, r5);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r4 = -1;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x010d;
    L_0x00cc:
        monitor-exit(r9);
        return r0;
    L_0x00ce:
        r0 = "DataAccessDBImpl";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = "update record...ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = ",apnName:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r2 = r2.append(r10);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = ",domain:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = r11.a();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = ",ip:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r3 = r11.d();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
        com.tencent.tencentmap.mapsdk.a.fx.b(r0, r2);	 Catch:{ Exception -> 0x010f, all -> 0x0112 }
    L_0x010d:
        r0 = r1;
        goto L_0x00cc;
    L_0x010f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00cc;
    L_0x0112:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.et.a(java.lang.String, com.tencent.tencentmap.mapsdk.a.eq$a, long):boolean");
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            fx.b("DataAccessDBImpl", "db created.");
        } catch (SQLException e) {
            throw e;
        }
    }

    public final synchronized eq a(String str) {
        Throwable th;
        Cursor cursor;
        eq eqVar;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            while (true) {
                if (readableDatabase.isDbLockedByOtherThreads() || readableDatabase.isDbLockedByCurrentThread()) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                }
            }
            Cursor query = readableDatabase.query("access_tbl", null, "apn=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        eq eqVar2 = new eq(str);
                        do {
                            String string = query.getString(query.getColumnIndex("domain"));
                            String string2 = query.getString(query.getColumnIndex("iplist"));
                            String string3 = query.getString(query.getColumnIndex("last_suc_ip"));
                            String string4 = query.getString(query.getColumnIndex("rule"));
                            long j = query.getLong(query.getColumnIndex("schedule_lasttime"));
                            query.getLong(query.getColumnIndex("apn_lasttime"));
                            eqVar2.a(new a(string, j, string2, string4, string3));
                        } while (query.moveToNext());
                        eqVar = eqVar2;
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            eqVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            eqVar = null;
        }
        return eqVar;
    }

    public final synchronized void a(eq eqVar) {
        Throwable th;
        Object obj = null;
        synchronized (this) {
            if (eqVar != null) {
                try {
                    Map a = eqVar.a();
                    long currentTimeMillis = System.currentTimeMillis();
                    for (a a2 : a.values()) {
                        obj = a(eqVar.b(), a2, currentTimeMillis) ? 1 : obj;
                    }
                    if (obj != null) {
                        try {
                            Cursor cursor;
                            String str = "";
                            fx.c("DataAccessDBImpl", "removeRecordIfNeeded...");
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            while (true) {
                                if (writableDatabase.isDbLockedByOtherThreads() || writableDatabase.isDbLockedByCurrentThread()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = null;
                                    }
                                }
                            }
                            cursor = writableDatabase.query("access_tbl", new String[]{"apn"}, null, null, "apn", null, "apn_lasttime");
                            if (cursor != null) {
                                try {
                                    if (cursor.getCount() > dx.a().b.c && cursor.moveToFirst()) {
                                        obj = cursor.getString(cursor.getColumnIndex("apn"));
                                        if (!TextUtils.isEmpty(obj)) {
                                            fx.c("DataAccessDBImpl", "removeRecordIfNeeded...found oldest apn:" + obj);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (!TextUtils.isEmpty(obj)) {
                                                fx.c("DataAccessDBImpl", "removeRecordIfNeeded...delete apn:" + obj + ", ret:" + writableDatabase.delete("access_tbl", "apn=?", new String[]{obj}));
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            String str2 = str;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (TextUtils.isEmpty(obj)) {
                                fx.c("DataAccessDBImpl", "removeRecordIfNeeded...delete apn:" + obj + ", ret:" + writableDatabase.delete("access_tbl", "apn=?", new String[]{obj}));
                            }
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                } catch (Throwable th4) {
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            while (true) {
                if (!writableDatabase.isDbLockedByOtherThreads() && !writableDatabase.isDbLockedByCurrentThread()) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_suc_ip", str3);
            fx.b("DataAccessDBImpl", "updateApnUseTime... for apn:" + str + ",updateRet:" + writableDatabase.update("access_tbl", contentValues, "apn=? and domain=?", new String[]{str, str2}));
        } catch (Exception e2) {
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            fx.b("DataAccessDBImpl", "db created.");
        } catch (Throwable e) {
            fx.a("DataAccessDBImpl", "db create failed.", e);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            fx.b("DataAccessDBImpl", "db created.");
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version == 0) {
                return;
            }
            if (version < 5) {
                try {
                    a(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e) {
                }
            } else if (version > 5) {
                try {
                    a(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            fx.b("DataAccessDBImpl", "db created.");
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }
}
