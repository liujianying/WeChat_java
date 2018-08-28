package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class i<T extends c> extends j implements d<T> {
    private final e diF;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    public final a sKB;
    private final String table;

    public i(e eVar, a aVar, String str, String[] strArr) {
        int i = 0;
        this.diF = eVar;
        this.sKB = aVar;
        this.sKB.sKz = bi.oW(this.sKB.sKz) ? "rowid" : this.sKB.sKz;
        this.table = str;
        List a = a(this.sKB, getTableName(), this.diF);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (!this.diF.fV(this.table, (String) a.get(i2))) {
                x.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.table, a.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.diF.fV(this.table, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.table;
    }

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.sql);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, e eVar) {
        List<String> arrayList = new ArrayList();
        if (eVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.e(str2, str3, objArr);
            return arrayList;
        }
        Cursor b = eVar.b("PRAGMA table_info( " + str + " )", new String[0], 2);
        if (b == null) {
            return arrayList;
        }
        Map hashMap = new HashMap();
        int columnIndex = b.getColumnIndex("name");
        int columnIndex2 = b.getColumnIndex("type");
        while (b.moveToNext()) {
            hashMap.put(b.getString(columnIndex), b.getString(columnIndex2));
        }
        b.close();
        for (Entry entry : aVar.sKA.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    x.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    public final boolean fV(String str, String str2) {
        if (str.length() == 0) {
            Xr("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.diF.fV(str, str2);
        } else {
            Xr("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public boolean a(T t, boolean z) {
        ContentValues wH = t.wH();
        if (wH == null || wH.size() <= 0) {
            Xr("insert failed, value.size <= 0");
            return false;
        }
        t.sKx = this.diF.insert(getTableName(), this.sKB.sKz, wH);
        if (t.sKx <= 0) {
            Xr("insert failed");
            return false;
        }
        wH.put("rowid", Long.valueOf(t.sKx));
        if (z) {
            Xp(wH.getAsString(this.sKB.sKz));
        }
        return true;
    }

    public boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues wH = t.wH();
        if (wH == null || wH.size() <= 0) {
            Xr("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Xq("delete with primary key");
            if (this.diF.delete(getTableName(), this.sKB.sKz + " = ?", new String[]{bi.oV(wH.getAsString(this.sKB.sKz))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(wH, strArr);
            if (a == null) {
                Xr("delete failed, check keys failed");
                return false;
            } else if (this.diF.delete(getTableName(), a.toString(), a(strArr, wH)) <= 0 || !z) {
                Xr("delete failed");
                return false;
            } else {
                Xp(this.sKB.sKz);
                return true;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return a((c) t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.diF.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        }
        return z;
    }

    public final boolean b(long j, T t) {
        Cursor a = this.diF.a(getTableName(), this.sKB.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.d(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues wH = t.wH();
        Cursor a;
        if (wH == null || wH.size() <= 0) {
            Xr("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Xq("get with primary key");
            a = this.diF.a(getTableName(), this.sKB.columns, this.sKB.sKz + " = ?", new String[]{bi.oV(wH.getAsString(this.sKB.sKz))}, null, null, null, 2);
            if (a.moveToFirst()) {
                t.d(a);
                a.close();
                return true;
            }
            a.close();
            return false;
        } else {
            StringBuilder a2 = a(wH, strArr);
            if (a2 == null) {
                Xr("get failed, check keys failed");
                return false;
            }
            a = this.diF.a(getTableName(), this.sKB.columns, a2.toString(), a(strArr, wH), null, null, null, 2);
            if (a.moveToFirst()) {
                t.d(a);
                a.close();
                return true;
            }
            a.close();
            Xq("get failed, not found");
            return false;
        }
    }

    public final boolean a(long j, T t, boolean z) {
        ContentValues wH = t.wH();
        if (wH == null || wH.size() <= 0) {
            Xr("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.diF.query(getTableName(), this.sKB.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(wH, query)) {
            query.close();
            Xq("no need replace , fields no change");
            return true;
        }
        boolean z2;
        query.close();
        if (this.diF.update(getTableName(), wH, "rowid = ?", new String[]{String.valueOf(j)}) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !z) {
            return z2;
        }
        doNotify();
        return z2;
    }

    public boolean a(long j, T t) {
        return a(j, (c) t, true);
    }

    public boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues wH = t.wH();
        if (wH == null || wH.size() <= 0) {
            Xr("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Xq("update with primary key");
            if (b(wH)) {
                Xq("no need replace , fields no change");
                return true;
            }
            if (this.diF.update(getTableName(), wH, this.sKB.sKz + " = ?", new String[]{bi.oV(wH.getAsString(this.sKB.sKz))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(wH, strArr);
            if (a == null) {
                Xr("update failed, check keys failed");
                return false;
            } else if (this.diF.update(getTableName(), wH, a.toString(), a(strArr, wH)) > 0) {
                if (z) {
                    Xp(wH.getAsString(this.sKB.sKz));
                }
                return true;
            } else {
                Xr("update failed");
                return false;
            }
        }
    }

    public boolean c(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !bi.oW(this.sKB.sKz));
        ContentValues wH = t.wH();
        if (wH != null) {
            int i;
            int size = wH.size();
            int length = t.AX().sKy.length;
            if (wH.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (b(wH)) {
                    Xq("no need replace , fields no change");
                    return true;
                } else if (this.diF.replace(getTableName(), this.sKB.sKz, wH) > 0) {
                    Xp(this.sKB.sKz);
                    return true;
                } else {
                    Xr("replace failed");
                    return false;
                }
            }
        }
        Xr("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean b(ContentValues contentValues) {
        Cursor query = this.diF.query(getTableName(), this.sKB.columns, this.sKB.sKz + " = ?", new String[]{bi.oV(contentValues.getAsString(this.sKB.sKz))}, null, null, null);
        boolean a = c.a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor axc() {
        return this.diF.query(getTableName(), this.sKB.columns, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.diF.rawQuery(str, strArr);
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = bi.oV(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void Xq(String str) {
        x.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void Xr(String str) {
        x.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }
}
