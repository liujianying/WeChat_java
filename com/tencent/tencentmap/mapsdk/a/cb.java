package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class cb {
    public long a;
    public byte[] b;
    private int c;
    private int d;
    private long e;
    private long f;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List a(android.content.Context r11) {
        /*
        r9 = 0;
        r10 = com.tencent.tencentmap.mapsdk.a.cb.class;
        monitor-enter(r10);
        r0 = " AnalyticsDAO.queryReqData() start";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00b3 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r0, r1);	 Catch:{ all -> 0x00b3 }
        if (r11 != 0) goto L_0x001b;
    L_0x000f:
        r0 = " AnalyticsDAO.queryReqData() context null ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00b3 }
        com.tencent.tencentmap.mapsdk.a.ct.d(r0, r1);	 Catch:{ all -> 0x00b3 }
        r0 = r9;
    L_0x0019:
        monitor-exit(r10);
        return r0;
    L_0x001b:
        r0 = com.tencent.tencentmap.mapsdk.a.cd.a(r11);	 Catch:{ Exception -> 0x00b6, all -> 0x00cf }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x00b6, all -> 0x00cf }
        r1 = "t_req_data";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "_time DESC ";
        r8 = "1";
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x00b6, all -> 0x00cf }
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00e8, all -> 0x00e6 }
        if (r0 == 0) goto L_0x00ed;
    L_0x003b:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e8, all -> 0x00e6 }
        r0.<init>();	 Catch:{ Exception -> 0x00e8, all -> 0x00e6 }
        r2 = "_id";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r0.add(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = "_rid";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r0.add(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = "_time";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = r1.getLong(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r0.add(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = "_datas";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = r1.getBlob(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r0.add(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = "_cnt";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        r0.add(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
    L_0x0092:
        if (r0 == 0) goto L_0x009d;
    L_0x0094:
        r2 = "queryReqData: 1";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
        com.tencent.tencentmap.mapsdk.a.ct.a(r2, r3);	 Catch:{ Exception -> 0x00eb, all -> 0x00e6 }
    L_0x009d:
        if (r1 == 0) goto L_0x00a8;
    L_0x009f:
        r2 = r1.isClosed();	 Catch:{ all -> 0x00b3 }
        if (r2 != 0) goto L_0x00a8;
    L_0x00a5:
        r1.close();	 Catch:{ all -> 0x00b3 }
    L_0x00a8:
        r1 = " AnalyticsDAO.queryReqData() end";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b3 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r1, r2);	 Catch:{ all -> 0x00b3 }
        goto L_0x0019;
    L_0x00b3:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x00b6:
        r0 = move-exception;
        r0 = r9;
        r1 = r9;
    L_0x00b9:
        if (r1 == 0) goto L_0x00c4;
    L_0x00bb:
        r2 = r1.isClosed();	 Catch:{ all -> 0x00b3 }
        if (r2 != 0) goto L_0x00c4;
    L_0x00c1:
        r1.close();	 Catch:{ all -> 0x00b3 }
    L_0x00c4:
        r1 = " AnalyticsDAO.queryReqData() end";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b3 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r1, r2);	 Catch:{ all -> 0x00b3 }
        goto L_0x0019;
    L_0x00cf:
        r0 = move-exception;
        r1 = r9;
    L_0x00d1:
        if (r1 == 0) goto L_0x00dc;
    L_0x00d3:
        r2 = r1.isClosed();	 Catch:{ all -> 0x00b3 }
        if (r2 != 0) goto L_0x00dc;
    L_0x00d9:
        r1.close();	 Catch:{ all -> 0x00b3 }
    L_0x00dc:
        r1 = " AnalyticsDAO.queryReqData() end";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b3 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r1, r2);	 Catch:{ all -> 0x00b3 }
        throw r0;	 Catch:{ all -> 0x00b3 }
    L_0x00e6:
        r0 = move-exception;
        goto L_0x00d1;
    L_0x00e8:
        r0 = move-exception;
        r0 = r9;
        goto L_0x00b9;
    L_0x00eb:
        r2 = move-exception;
        goto L_0x00b9;
    L_0x00ed:
        r0 = r9;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.cb.a(android.content.Context):java.util.List");
    }

    public cb() {
        this.a = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.b = null;
        this.f = 0;
    }

    public cb(long j, byte[] bArr) {
        this.a = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.b = null;
        this.f = 0;
        this.c = 1;
        this.d = 3;
        this.e = j;
        this.b = bArr;
        if (bArr != null) {
            this.f = (long) bArr.length;
        }
    }

    public static synchronized boolean a(Context context, byte[] bArr, String str, int i) {
        boolean z = false;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.insertReqData() start", new Object[0]);
            if (context == null || bArr == null || str == null) {
                ct.d(" AnalyticsDAO.insertReqData() have null args", new Object[0]);
            } else {
                try {
                    SQLiteDatabase writableDatabase = cd.a(context).getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_rid", str);
                    contentValues.put("_time", Long.valueOf(new Date().getTime()));
                    contentValues.put("_cnt", Integer.valueOf(i));
                    contentValues.put("_datas", bArr);
                    if (writableDatabase.insert("t_req_data", null, contentValues) < 0) {
                        ct.d(" AnalyticsDAO.insertReqData() failure! return", new Object[0]);
                    } else {
                        z = true;
                    }
                    ct.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                } catch (Throwable th) {
                    ct.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                }
            }
        }
        return z;
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z = false;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.deleteReqData() start", new Object[0]);
            if (context == null) {
                ct.a(" delete() context is null arg", new Object[0]);
            } else if (str != null) {
                if (!str.trim().equals("")) {
                    String str2 = "_rid = '" + str + "' ";
                    ct.b(" delete where: " + str2, new Object[0]);
                    try {
                        int delete = cd.a(context).getWritableDatabase().delete("t_req_data", str2, null);
                        ct.b(" deleted num: " + delete, new Object[0]);
                        if (delete == 1) {
                            z = true;
                        }
                        ct.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                    } catch (Throwable th) {
                        ct.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                    }
                }
            }
        }
        return z;
    }

    public static synchronized boolean a(Context context, List<cb> list) {
        boolean z;
        Throwable th;
        boolean z2 = true;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.insert() start", new Object[0]);
            if (context == null || list == null) {
                ct.d(" AnalyticsDAO.insert() have null args", new Object[0]);
                z2 = false;
            } else if (list.size() <= 0) {
                ct.b(" list size == 0 return true", new Object[0]);
            } else {
                SQLiteDatabase sQLiteDatabase = null;
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = cd.a(context).getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        for (int i = 0; i < list.size(); i++) {
                            cb cbVar = (cb) list.get(i);
                            ContentValues contentValues = new ContentValues();
                            if (cbVar.a > 0) {
                                contentValues.put("_id", Long.valueOf(cbVar.a));
                            }
                            contentValues.put("_prority", Integer.valueOf(cbVar.d));
                            contentValues.put("_time", Long.valueOf(cbVar.e));
                            contentValues.put("_type", Integer.valueOf(cbVar.c));
                            contentValues.put("_datas", cbVar.b);
                            contentValues.put("_length", Long.valueOf(cbVar.f));
                            long insert = writableDatabase.insert("t_event", "_id", contentValues);
                            if (insert < 0) {
                                ct.d(" AnalyticsDAO.insert() failure! return", new Object[0]);
                            }
                            cbVar.a = insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e) {
                            ct.b("AnalyticsDao db.endTransaction() error.", new Object[0]);
                        }
                        ct.b(" AnalyticsDAO.insert() end", new Object[0]);
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        writableDatabase.endTransaction();
                        ct.b(" AnalyticsDAO.insert() end", new Object[0]);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase = null;
                    writableDatabase.endTransaction();
                    ct.b(" AnalyticsDAO.insert() end", new Object[0]);
                    throw th;
                }
                z2 = z;
            }
        }
        return z2;
    }

    public static synchronized int a(Context context, int[] iArr) {
        int i = -1;
        int i2 = 0;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.delete() start", new Object[0]);
            if (context == null) {
                ct.a(" delete() context is null arg", new Object[0]);
            } else if (-1 > Long.MAX_VALUE) {
                i = 0;
            } else {
                String str;
                String str2 = "_time >= -1 and _time <= 9223372036854775807";
                if (iArr == null || iArr.length <= 0) {
                    str = str2;
                } else {
                    String str3 = "";
                    while (i2 < iArr.length) {
                        str3 = str3 + " or _type = " + iArr[i2];
                        i2++;
                    }
                    str = str2 + " and ( " + str3.substring(4) + " )";
                }
                ct.b(" delete where: " + str, new Object[0]);
                try {
                    i2 = cd.a(context).getWritableDatabase().delete("t_event", str, null);
                    ct.b(" deleted num: " + i2, new Object[0]);
                    ct.b(" AnalyticsDAO.delete() end", new Object[0]);
                } catch (Throwable th) {
                    ct.b(" AnalyticsDAO.delete() end", new Object[0]);
                }
                i = i2;
            }
        }
        return i;
    }

    public static synchronized int a(Context context, Long[] lArr) {
        int i;
        Throwable th;
        int i2 = 0;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.deleteList() start!", new Object[0]);
            if (context == null) {
                ct.d(" deleteList() have null args!", new Object[0]);
                i = -1;
            } else {
                if (lArr != null) {
                    if (lArr.length > 0) {
                        try {
                            SQLiteDatabase writableDatabase = cd.a(context).getWritableDatabase();
                            StringBuffer stringBuffer = new StringBuffer();
                            int i3 = 0;
                            while (true) {
                                try {
                                    i = i2;
                                    if (i3 >= lArr.length) {
                                        break;
                                    }
                                    stringBuffer.append(" or  _id = " + lArr[i3].longValue());
                                    if (i3 > 0 && i3 % 25 == 0) {
                                        ct.b(" current " + i3, new Object[0]);
                                        i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                                        stringBuffer.setLength(0);
                                        ct.b(" current deleteNum: " + i, new Object[0]);
                                    }
                                    i2 = i3 + 1;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        ct.d(th.getMessage(), new Object[0]);
                                        ct.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                        return i;
                                    } catch (Throwable th3) {
                                        ct.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                    }
                                }
                            }
                            if (stringBuffer.length() > 0) {
                                i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                                stringBuffer.setLength(0);
                            }
                            ct.a(" total deleteNum: " + i, new Object[0]);
                            ct.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                        } catch (Throwable th4) {
                            th = th4;
                            i = 0;
                            ct.d(th.getMessage(), new Object[0]);
                            ct.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                            return i;
                        }
                    }
                }
                i = 0;
            }
        }
        return i;
    }

    public static synchronized List<cb> a(Context context, int[] iArr, int i) {
        List<cb> b;
        synchronized (cb.class) {
            b = b(context, iArr, i);
        }
        return b;
    }

    private static List<cb> a(Cursor cursor) {
        ct.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
        if (cursor == null) {
            return null;
        }
        List<cb> arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_prority");
        int columnIndex3 = cursor.getColumnIndex("_time");
        int columnIndex4 = cursor.getColumnIndex("_type");
        int columnIndex5 = cursor.getColumnIndex("_datas");
        int columnIndex6 = cursor.getColumnIndex("_length");
        while (cursor.moveToNext()) {
            cb cbVar = new cb();
            cbVar.a = cursor.getLong(columnIndex);
            cbVar.b = cursor.getBlob(columnIndex5);
            cbVar.d = cursor.getInt(columnIndex2);
            cbVar.e = cursor.getLong(columnIndex3);
            cbVar.c = cursor.getInt(columnIndex4);
            cbVar.f = cursor.getLong(columnIndex6);
            arrayList.add(cbVar);
        }
        ct.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
        return arrayList;
    }

    public static synchronized int b(Context context, int[] iArr) {
        Throwable th;
        int i = -1;
        int i2 = 0;
        synchronized (cb.class) {
            ct.b(" AnalyticsDAO.querySum() start", new Object[0]);
            if (context == null) {
                ct.a(" querySum() context is null arg", new Object[0]);
            } else if (-1 > Long.MAX_VALUE) {
                i = 0;
            } else {
                String str = "_time >= -1 and _time <= 9223372036854775807";
                if (iArr != null && iArr.length > 0) {
                    String str2 = "";
                    while (i2 < iArr.length) {
                        str2 = str2 + " or _type = " + iArr[i2];
                        i2++;
                    }
                    str = str + " and ( " + str2.substring(4) + " )";
                }
                ct.b(" query where: " + str, new Object[0]);
                Cursor query;
                try {
                    query = cd.a(context).getWritableDatabase().query("t_event", new String[]{"count(*) as sum"}, str, null, null, null, null);
                    try {
                        query.moveToNext();
                        i2 = query.getInt(query.getColumnIndex("sum"));
                        ct.b(" query sum: " + i2, new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ct.b(" AnalyticsDAO.querySum() end", new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ct.b(th.getMessage(), new Object[0]);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            ct.b(" AnalyticsDAO.querySum() end", new Object[0]);
                            i2 = -1;
                            i = i2;
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (!(query == null || query.isClosed())) {
                                query.close();
                            }
                            ct.b(" AnalyticsDAO.querySum() end", new Object[0]);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    query = null;
                    query.close();
                    ct.b(" AnalyticsDAO.querySum() end", new Object[0]);
                    throw th;
                }
                i = i2;
            }
        }
        return i;
    }

    private static synchronized List<cb> b(Context context, int[] iArr, int i) {
        List<cb> c;
        synchronized (cb.class) {
            c = c(context, iArr, i);
        }
        return c;
    }

    private static synchronized List<cb> c(Context context, int[] iArr, int i) {
        List<cb> list;
        Throwable th;
        Throwable th2;
        synchronized (cb.class) {
            ct.b(" in AnalyticsDAO.query() start", new Object[0]);
            if (context == null || (-1 > 0 && -1 > -1)) {
                ct.d(" query() args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new Object[0]);
                list = null;
            } else {
                String str = "";
                if (iArr != null && iArr.length > 0) {
                    String str2 = "";
                    for (int i2 : iArr) {
                        str2 = str2 + " or _type = " + i2;
                    }
                    str = str + str2.substring(4);
                }
                String str3 = str.length() > 0 ? " ( " + str + " ) " : "";
                if (-1 >= 0) {
                    str3 = str3 + (str3.length() > 0 ? " and " : "") + "_time >= -1 ";
                }
                if (-1 >= 0) {
                    str3 = str3 + (str3.length() > 0 ? " and " : "") + "_time <= -1 ";
                }
                String str4 = ("" + "_prority ASC , ") + "_time DESC ";
                if (str4.endsWith(" , ")) {
                    str4 = str4.substring(0, str4.length() - 3);
                }
                ct.b(" query:%s", new Object[]{str3});
                Cursor query;
                try {
                    query = cd.a(context).getWritableDatabase().query("t_event", null, str3, null, null, null, str4, i >= 0 ? String.valueOf(i) : null);
                    try {
                        ct.a("result num: " + query.getCount(), new Object[0]);
                        if (query.getCount() > 0) {
                            list = a(query);
                        } else {
                            list = null;
                        }
                        if (list != null) {
                            try {
                                ct.a(" total num: " + list.size(), new Object[0]);
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    ct.b(th.getMessage(), new Object[0]);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    ct.b(" in AnalyticsDAO.query() end", new Object[0]);
                                    return list;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    ct.b(" in AnalyticsDAO.query() end", new Object[0]);
                                    throw th2;
                                }
                            }
                        }
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ct.b(" in AnalyticsDAO.query() end", new Object[0]);
                    } catch (Throwable th5) {
                        th = th5;
                        list = null;
                        ct.b(th.getMessage(), new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ct.b(" in AnalyticsDAO.query() end", new Object[0]);
                        return list;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    query = null;
                    query.close();
                    ct.b(" in AnalyticsDAO.query() end", new Object[0]);
                    throw th2;
                }
            }
        }
        return list;
    }
}
