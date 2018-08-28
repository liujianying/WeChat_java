package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.tencent.tencentmap.mapsdk.a.tc.a;

class te$c extends SQLiteOpenHelper {
    private SQLiteDatabase a;

    public te$c(te teVar, Context context) {
        super(context, "Cache.db", null, 1);
        this.a = null;
        this.a = getReadableDatabase();
        if (VERSION.SDK_INT > 10) {
            this.a.enableWriteAheadLogging();
        } else {
            this.a.setLockingEnabled(true);
        }
    }

    private static void a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (tile TEXT PRIMARY KEY UNIQUE,version TEXT,style TEXT,md5 TEXT,data BLOB )");
    }

    private static String b(a aVar) {
        switch (te$1.a[aVar.ordinal()]) {
            case 1:
                return "wmt";
            case 2:
                return "tct";
            case 3:
                return "stt";
            default:
                return "";
        }
    }

    private static String b(td tdVar) {
        switch (te$1.a[tdVar.m().ordinal()]) {
            case 1:
                return tdVar.d() + "-" + tdVar.b() + "-" + tdVar.c() + "-" + sl.q() + "-" + tdVar.n();
            case 2:
                return tdVar.d() + "-" + tdVar.b() + "-" + tdVar.c() + "-zh-" + tdVar.n();
            case 3:
                return tdVar.d() + "-" + tdVar.b() + "-" + tdVar.c();
            default:
                return null;
        }
    }

    private boolean c(td tdVar) {
        Cursor cursor = null;
        boolean z = true;
        try {
            cursor = this.a.rawQuery("select count(*) as ct from " + b(tdVar.m()) + " where " + "tile" + " = '" + b(tdVar) + "'", null);
            if (cursor == null || cursor.getCount() <= 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            cursor.moveToFirst();
            if (cursor.getInt(cursor.getColumnIndex("ct")) <= 0) {
                z = false;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final tf a(td tdVar) {
        Throwable th;
        if (this.a == null) {
            return null;
        }
        String str = "select * from " + b(tdVar.m()) + " where tile = ?";
        Cursor rawQuery;
        try {
            rawQuery = this.a.rawQuery(str, new String[]{b(tdVar)});
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        byte[] blob = rawQuery.getBlob(rawQuery.getColumnIndex("data"));
                        String string = rawQuery.getString(rawQuery.getColumnIndex("md5"));
                        tf tfVar = new tf(te.a(blob, string), rawQuery.getInt(rawQuery.getColumnIndex("version")), string);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return tfVar;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        new StringBuilder("getBitmap error:").append(th.toString());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return new tf(null, sn.b(), "");
                    } catch (Throwable th3) {
                        th = th3;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th4) {
            th = th4;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return new tf(null, sn.b(), "");
    }

    public final boolean a(a aVar) {
        if (this.a == null) {
            return false;
        }
        try {
            this.a.execSQL("delete  from " + b(aVar));
            return true;
        } catch (Throwable th) {
            new StringBuilder("cleanCache Error:").append(th.toString());
            return false;
        }
    }

    public final boolean a(td tdVar, byte[] bArr) {
        if (this.a == null) {
            return false;
        }
        try {
            String a = te.a(bArr);
            byte[] b = te.b(bArr, a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("tile", b(tdVar));
            contentValues.put("data", b);
            contentValues.put("md5", a);
            a m = tdVar.m();
            if (m == a.b) {
                contentValues.put("style", Integer.valueOf(sn.e()));
            }
            if (m == a.a) {
                contentValues.put("style", Integer.valueOf(sn.a()));
            }
            contentValues.put("version", Integer.valueOf(tdVar.l()));
            return this.a.insert(b(tdVar.m()), null, contentValues) != -1;
        } catch (Throwable th) {
            new StringBuilder("putBitmap Error:").append(th.toString());
            return false;
        }
    }

    public final boolean a(td tdVar, byte[] bArr, boolean z) {
        if (this.a == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            String str = "tile = ? ";
            String[] strArr = new String[]{b(tdVar)};
            contentValues.put("version", Integer.valueOf(tdVar.l()));
            String a = te.a(bArr);
            byte[] b = te.b(bArr, a);
            if (!(z || b == null)) {
                contentValues.put("md5", a);
                contentValues.put("data", b);
            }
            return this.a.update(b(tdVar.m()), contentValues, str, strArr) > 0;
        } catch (Throwable th) {
            new StringBuilder("updateBitmap Error:").append(th.toString());
            return false;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a("tct", sQLiteDatabase);
        a("wmt", sQLiteDatabase);
        a("stt", sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
        onCreate(sQLiteDatabase);
    }
}
