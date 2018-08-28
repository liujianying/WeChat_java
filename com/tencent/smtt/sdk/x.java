package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.File;
import java.util.ArrayList;

public class x {
    public static final String a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return b;
    }

    private static String a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return stringBuilder.toString();
        }
        do {
            stringBuilder.append("\n");
            for (count = 0; count < columnCount; count++) {
                try {
                    stringBuilder.append(rawQuery.getString(count)).append(",");
                } catch (Exception e) {
                }
            }
            stringBuilder.append("\n");
        } while (rawQuery.moveToNext());
        return stringBuilder.toString();
    }

    public static ArrayList<String> a(SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        if (sQLiteDatabase == null) {
            return obj;
        }
        ArrayList<String> arrayList = new ArrayList();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(1);
                    rawQuery.getString(4);
                    arrayList.add(string);
                    a(sQLiteDatabase, string);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (obj != null) {
                obj.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r10, com.tencent.smtt.sdk.CookieManager.a r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
        r1 = 0;
        r2 = 1;
        r3 = 0;
        if (r10 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = com.tencent.smtt.sdk.CookieManager.a.b;
        if (r11 != r0) goto L_0x0010;
    L_0x000a:
        r0 = android.text.TextUtils.isEmpty(r12);
        if (r0 != 0) goto L_0x0005;
    L_0x0010:
        r0 = ",";
        r4 = r12.split(r0);
        if (r4 == 0) goto L_0x0005;
    L_0x0019:
        r0 = r4.length;
        if (r0 <= 0) goto L_0x0005;
    L_0x001c:
        r5 = c(r10);
        if (r5 == 0) goto L_0x0005;
    L_0x0022:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = "select * from cookies";
        r7 = 0;
        r1 = r5.rawQuery(r0, r7);	 Catch:{ Throwable -> 0x00fd }
        r0 = r1.getCount();	 Catch:{ Throwable -> 0x00fd }
        if (r0 <= 0) goto L_0x00b8;
    L_0x0035:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x00fd }
        if (r0 == 0) goto L_0x00b8;
    L_0x003b:
        r0 = "host_key";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00fd }
        r7 = r1.getString(r0);	 Catch:{ Throwable -> 0x00fd }
        r0 = com.tencent.smtt.sdk.CookieManager.a.b;	 Catch:{ Throwable -> 0x00fd }
        if (r11 != r0) goto L_0x0059;
    L_0x004a:
        r8 = r4.length;	 Catch:{ Throwable -> 0x00fd }
        r0 = r3;
    L_0x004c:
        if (r0 >= r8) goto L_0x015d;
    L_0x004e:
        r9 = r4[r0];	 Catch:{ Throwable -> 0x00fd }
        r9 = r7.equals(r9);	 Catch:{ Throwable -> 0x00fd }
        if (r9 == 0) goto L_0x00f9;
    L_0x0056:
        r0 = r2;
    L_0x0057:
        if (r0 == 0) goto L_0x00b2;
    L_0x0059:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fd }
        r0.<init>();	 Catch:{ Throwable -> 0x00fd }
        r8 = "value";
        r8 = r1.getColumnIndex(r8);	 Catch:{ Throwable -> 0x00fd }
        r8 = r1.getString(r8);	 Catch:{ Throwable -> 0x00fd }
        r0.append(r8);	 Catch:{ Throwable -> 0x00fd }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x00fd }
        r9 = "name";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x00fd }
        r9 = r1.getString(r9);	 Catch:{ Throwable -> 0x00fd }
        r8.append(r9);	 Catch:{ Throwable -> 0x00fd }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x00fd }
        r9 = "expires_utc";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x00fd }
        r9 = r1.getInt(r9);	 Catch:{ Throwable -> 0x00fd }
        r8.append(r9);	 Catch:{ Throwable -> 0x00fd }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x00fd }
        r9 = "priority";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x00fd }
        r9 = r1.getInt(r9);	 Catch:{ Throwable -> 0x00fd }
        r8.append(r9);	 Catch:{ Throwable -> 0x00fd }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00fd }
        r6.put(r7, r0);	 Catch:{ Throwable -> 0x00fd }
    L_0x00b2:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x00fd }
        if (r0 != 0) goto L_0x003b;
    L_0x00b8:
        if (r1 == 0) goto L_0x00bd;
    L_0x00ba:
        r1.close();
    L_0x00bd:
        if (r5 == 0) goto L_0x00c8;
    L_0x00bf:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x00c8;
    L_0x00c5:
        r5.close();
    L_0x00c8:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0005;
    L_0x00ce:
        b(r10);
        r0 = r6.entrySet();
        r3 = r0.iterator();
    L_0x00d9:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0130;
    L_0x00df:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r4 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r4.setCookie(r1, r0, r2);
        goto L_0x00d9;
    L_0x00f9:
        r0 = r0 + 1;
        goto L_0x004c;
    L_0x00fd:
        r0 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011e }
        r4 = "getCookieDBVersion exception:";
        r3.<init>(r4);	 Catch:{ all -> 0x011e }
        r0 = r0.toString();	 Catch:{ all -> 0x011e }
        r3.append(r0);	 Catch:{ all -> 0x011e }
        if (r1 == 0) goto L_0x0112;
    L_0x010f:
        r1.close();
    L_0x0112:
        if (r5 == 0) goto L_0x00c8;
    L_0x0114:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x00c8;
    L_0x011a:
        r5.close();
        goto L_0x00c8;
    L_0x011e:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0124;
    L_0x0121:
        r1.close();
    L_0x0124:
        if (r5 == 0) goto L_0x012f;
    L_0x0126:
        r1 = r5.isOpen();
        if (r1 == 0) goto L_0x012f;
    L_0x012c:
        r5.close();
    L_0x012f:
        throw r0;
    L_0x0130:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x0155;
    L_0x0136:
        r0 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r0.flush();
    L_0x013d:
        if (r13 == 0) goto L_0x0005;
    L_0x013f:
        r0 = c(r10);
        a(r0);
        r0 = d(r10);
        r1 = -1;
        if (r0 == r1) goto L_0x0005;
    L_0x014d:
        com.tencent.smtt.sdk.CookieManager.getInstance();
        com.tencent.smtt.sdk.CookieManager.setROMCookieDBVersion(r10, r0);
        goto L_0x0005;
    L_0x0155:
        r0 = com.tencent.smtt.sdk.CookieSyncManager.getInstance();
        r0.sync();
        goto L_0x013d;
    L_0x015d:
        r0 = r3;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.x.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        j.a(a(context), false);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        if (context != null) {
            File a = a(context);
            if (a != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openDatabase(a.getAbsolutePath(), null, 0);
                } catch (Exception e) {
                }
                if (sQLiteDatabase == null) {
                    TbsLog.i(a, "dbPath is not exist!");
                }
            }
        }
        return sQLiteDatabase;
    }

    public static int d(Context context) {
        SQLiteDatabase c;
        Cursor rawQuery;
        Throwable th;
        int i = 0;
        System.currentTimeMillis();
        try {
            c = c(context);
            if (c == null) {
                if (c != null && c.isOpen()) {
                    c.close();
                }
                return -1;
            }
            try {
                rawQuery = c.rawQuery("select * from meta", null);
                try {
                    int count = rawQuery.getCount();
                    rawQuery.getColumnCount();
                    if (count > 0 && rawQuery.moveToFirst()) {
                        while (!rawQuery.getString(0).equals("version")) {
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                        }
                        i = Integer.parseInt(rawQuery.getString(1));
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (c == null || !c.isOpen()) {
                        return i;
                    }
                    c.close();
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (c != null && c.isOpen()) {
                    c.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            rawQuery = null;
            c = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            c.close();
            throw th;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (c == null || !c.isOpen()) {
            return 0;
        }
        c.close();
        return 0;
    }
}
