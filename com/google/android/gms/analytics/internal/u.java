package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

final class u extends o implements Closeable {
    private static final String aGA = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private static final String aGz = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private final a aGB;
    private final j aGC = new j(this.aFn.aFC);
    private final j aGD = new j(this.aFn.aFC);

    u(q qVar) {
        super(qVar);
        this.aGB = new a(this, qVar.mContext, nE());
    }

    private List<Long> Z(long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        q.nx();
        np();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        List<Long> arrayList = new ArrayList();
        Cursor query;
        try {
            query = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    f("Error selecting hit ids", e);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    private long a(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery == null) {
                        return j;
                    }
                    rawQuery.close();
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    d("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        }
    }

    private long aT(String str) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, null);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private Map<String, String> aU(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            g("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private Map<String, String> aV(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            g("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    private SQLiteDatabase getWritableDatabase() {
        try {
            return this.aGB.getWritableDatabase();
        } catch (SQLiteException e) {
            f("Error opening database", e);
            throw e;
        }
    }

    private long nA() {
        q.nx();
        np();
        return aT("SELECT COUNT(*) FROM hits2");
    }

    private String nE() {
        return !f.aNr ? "google_analytics_v4.db" : this.aFn.aFV.nT() ? "google_analytics_v4.db" : "google_analytics2_v4.db";
    }

    public final long a(long j, String str, String str2) {
        w.bg(str);
        w.bg(str2);
        np();
        q.nx();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.analytics.internal.c> aa(long r14) {
        /*
        r13 = this;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0097;
    L_0x0009:
        com.google.android.gms.common.internal.w.au(r0);
        com.google.android.gms.analytics.internal.q.nx();
        r13.np();
        r0 = r13.getWritableDatabase();
        r1 = "hits2";
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 1;
        r4 = "hit_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 2;
        r4 = "hit_string";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 3;
        r4 = "hit_url";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 4;
        r4 = "hit_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = 0;
        r11 = "hit_id";
        r8[r10] = r11;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.<init>();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 == 0) goto L_0x0091;
    L_0x0061:
        r0 = 0;
        r6 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 1;
        r3 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 2;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = 3;
        r1 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = 4;
        r8 = r9.getInt(r2);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = r13.aU(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r5 = com.google.android.gms.analytics.internal.k.aN(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = new com.google.android.gms.analytics.internal.c;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.add(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 != 0) goto L_0x0061;
    L_0x0091:
        if (r9 == 0) goto L_0x0096;
    L_0x0093:
        r9.close();
    L_0x0096:
        return r10;
    L_0x0097:
        r0 = r1;
        goto L_0x0009;
    L_0x009a:
        r0 = move-exception;
        r1 = r9;
    L_0x009c:
        r2 = "Error loading hits from the database";
        r13.g(r2, r0);	 Catch:{ all -> 0x00a3 }
        throw r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r0 = move-exception;
        r9 = r1;
    L_0x00a5:
        if (r9 == 0) goto L_0x00aa;
    L_0x00a7:
        r9.close();
    L_0x00aa:
        throw r0;
    L_0x00ab:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x00ad:
        r0 = move-exception;
        r1 = r9;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.u.aa(long):java.util.List<com.google.android.gms.analytics.internal.c>");
    }

    public final void ab(long j) {
        q.nx();
        np();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        d("Deleting hit, id", Long.valueOf(j));
        u(arrayList);
    }

    public final void b(long j, String str) {
        w.bg(str);
        np();
        q.nx();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            d("Deleted property records", Integer.valueOf(delete));
        }
    }

    public final void b(s sVar) {
        w.ah(sVar);
        np();
        q.nx();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Map map = sVar.aFa;
        w.ah(map);
        Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(sVar.aGk));
        contentValues.put("cid", sVar.aGl);
        contentValues.put("tid", sVar.aGm);
        contentValues.put("adid", Integer.valueOf(sVar.aGn ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(sVar.aGo));
        contentValues.put("params", encodedQuery);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                aS("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            g("Error storing a property", e);
        }
    }

    public final void beginTransaction() {
        np();
        getWritableDatabase().beginTransaction();
    }

    public final void close() {
        try {
            this.aGB.close();
        } catch (SQLiteException e) {
            g("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            g("Error closing database", e2);
        }
    }

    public final void e(c cVar) {
        String str;
        w.ah(cVar);
        q.nx();
        np();
        w.ah(cVar);
        Builder builder = new Builder();
        for (Entry entry : cVar.aFa.entrySet()) {
            str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        str = encodedQuery == null ? "" : encodedQuery;
        if (str.length() > 8192) {
            this.aFn.nr().a(cVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) aj.aHw.get()).intValue();
        long nA = nA();
        if (nA > ((long) (intValue - 1))) {
            List Z = Z((nA - ((long) intValue)) + 1);
            f("Store full, deleting hits to make room, count", Integer.valueOf(Z.size()));
            u(Z);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", str);
        contentValues.put("hit_time", Long.valueOf(cVar.aFd));
        contentValues.put("hit_app_id", Integer.valueOf(cVar.aFe));
        contentValues.put("hit_url", cVar.aFf ? ac.oa() : ac.ob());
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                aS("Failed to insert a hit (got -1)");
            } else {
                b("Hit saved to database. db-id, hit", Long.valueOf(insert), cVar);
            }
        } catch (SQLiteException e) {
            g("Error storing a hit", e);
        }
    }

    public final void endTransaction() {
        np();
        getWritableDatabase().endTransaction();
    }

    final boolean isEmpty() {
        return nA() == 0;
    }

    protected final void mE() {
    }

    public final int nB() {
        q.nx();
        np();
        if (!this.aGC.Y(86400000)) {
            return 0;
        }
        this.aGC.start();
        aO("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(this.aFn.aFC.currentTimeMillis() - 2592000000L)});
        d("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long nC() {
        q.nx();
        np();
        return a(aGA, null);
    }

    public final List<s> nD() {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        np();
        q.nx();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            String[] strArr = new String[]{"cid", "tid", "adid", "hits_count", "params"};
            int intValue = ((Integer) aj.aHy.get()).intValue();
            String str = "properties";
            Cursor query = writableDatabase.query(str, strArr, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(intValue));
            try {
                List<s> arrayList = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        Object string = query.getString(0);
                        Object string2 = query.getString(1);
                        boolean z = query.getInt(2) != 0;
                        long j = (long) query.getInt(3);
                        Map aV = aV(query.getString(4));
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                            c("Read property with empty client id or tracker id", string, string2);
                        } else {
                            arrayList.add(new s(string, string2, z, j, aV));
                        }
                    } while (query.moveToNext());
                }
                if (arrayList.size() >= intValue) {
                    aR("Sending hits to too many properties. Campaign report might be incorrect");
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            g("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void setTransactionSuccessful() {
        np();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final void u(List<Long> list) {
        w.ah(list);
        q.nx();
        np();
        if (!list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Long l = (Long) list.get(i2);
                    if (l != null && l.longValue() != 0) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(l);
                        i = i2 + 1;
                    }
                } else {
                    stringBuilder.append(")");
                    String stringBuilder2 = stringBuilder.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        d("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                        i = writableDatabase.delete("hits2", stringBuilder2, null);
                        if (i != list.size()) {
                            a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                            return;
                        }
                        return;
                    } catch (SQLiteException e) {
                        g("Error deleting hits", e);
                        throw e;
                    }
                }
            }
            throw new SQLiteException("Invalid hit id");
        }
    }
}
