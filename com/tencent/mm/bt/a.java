package com.tencent.mm.bt;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    public static final Pattern tdj = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    private String Yy = "";
    String aAL;
    private boolean isNew = false;
    f tdk;
    String tdl = "";
    public boolean tdm = false;
    String tdn = "";
    public boolean tdo = false;

    public final String getError() {
        if (bi.oW(this.Yy) || bi.oW(this.tdn)) {
            return "";
        }
        if (!bi.oW(com.tencent.mm.sdk.e.a.getValue(this.tdn, "Reported"))) {
            return "";
        }
        com.tencent.mm.sdk.e.a.ap(this.tdn, "Reported", "true");
        return this.Yy;
    }

    private void gc(String str, String str2) {
        Set hashSet = new HashSet();
        String str3 = "";
        Cursor b = this.tdk.b("select * from " + str + " limit 1 ", null, 0);
        if (b.getCount() == 0) {
            b.close();
            return;
        }
        b.moveToFirst();
        for (int i = 0; i < b.getColumnCount(); i++) {
            hashSet.add(b.getColumnName(i));
        }
        b.close();
        b = this.tdk.b("PRAGMA table_info( " + str2 + " )", null, 0);
        String str4 = str3;
        while (b.moveToNext()) {
            str3 = b.getString(b.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        b.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.tdk.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
    }

    private boolean p(Cursor cursor) {
        int i;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            hashSet.add(cursor.getString(0));
        }
        Cursor b = this.tdk.b("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (b == null) {
            return false;
        }
        for (i = 0; i < b.getCount(); i++) {
            b.moveToPosition(i);
            hashSet2.add(b.getString(0));
        }
        b.close();
        this.tdk.beginTransaction();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashSet.contains(str)) {
                Cursor b2 = this.tdk.b("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0);
                if (b2 != null) {
                    this.tdk.execSQL(b2.getString(0));
                    b2.close();
                }
            }
        }
        this.tdk.endTransaction();
        return true;
    }

    private List<String> gd(String str, String str2) {
        List<String> arrayList = new ArrayList();
        if (this.tdk == null) {
            return arrayList;
        }
        Cursor b = this.tdk.b("PRAGMA table_info( " + str + " )", null, 0);
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
        b = this.tdk.b("PRAGMA table_info( " + str2 + " )", null, 0);
        if (b == null) {
            return arrayList;
        }
        Map hashMap2 = new HashMap();
        columnIndex = b.getColumnIndex("name");
        columnIndex2 = b.getColumnIndex("type");
        while (b.moveToNext()) {
            hashMap.put(b.getString(columnIndex), b.getString(columnIndex2));
        }
        b.close();
        Iterator it = new HashSet(hashMap.entrySet()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 != null && str4.length() > 0) {
                String str5 = (String) hashMap2.get(str3);
                if (str5 == null) {
                    arrayList.add("ALTER TABLE " + str2 + " ADD COLUMN " + str3 + " " + str4 + ";");
                    hashMap.remove(str3);
                } else if (!str4.toLowerCase().startsWith(str5.toLowerCase())) {
                    x.e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        return arrayList;
    }

    private boolean ge(String str, String str2) {
        Cursor b = this.tdk.b("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (b == null) {
            return false;
        }
        try {
            if (bi.oW(str2)) {
                this.tdk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.tdk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (!p(b)) {
                return false;
            }
            this.tdk.beginTransaction();
            for (int i = 0; i < b.getCount(); i++) {
                int count;
                b.moveToPosition(i);
                Cursor b2 = this.tdk.b("select * from old.sqlite_master where tbl_name = '" + b.getString(0) + "'", null, 0);
                if (b2 != null) {
                    count = b2.getCount();
                    b2.close();
                } else {
                    count = 0;
                }
                if (count == 0) {
                    x.w("MicroMsg.DBInit", "In old db not found :" + b.getString(0));
                } else {
                    try {
                        for (String execSQL : gd("old." + b.getString(0), b.getString(0))) {
                            this.tdk.execSQL(execSQL);
                        }
                        gc("old." + b.getString(0), b.getString(0));
                    } catch (Exception e) {
                        x.w("MicroMsg.DBInit", "Insertselect FAILED :" + b.getString(0));
                    }
                }
            }
            this.tdk.endTransaction();
            b.close();
            this.tdk.execSQL("DETACH DATABASE old;");
            return true;
        } catch (SQLiteDatabaseCorruptException e2) {
            x.e("MicroMsg.DBInit", "Attached database is corrupted: " + str);
            FileOp.deleteFile(str);
            throw e2;
        }
    }

    public final boolean a(String str, HashMap<Integer, d> hashMap, boolean z) {
        boolean z2 = false;
        if (this.tdk != null) {
            this.tdk.close();
            this.tdk = null;
        }
        try {
            x.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.valueOf(true), Boolean.valueOf(e.cn(str)), str);
            this.tdk = f.bs(str, z);
            if (!e.cn(str)) {
                z2 = true;
            }
            a((HashMap) hashMap, true, z2);
            return true;
        } catch (SQLiteException e) {
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        Object obj;
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !bi.oW(str2));
        this.tdn = str2 + ".errreport";
        if (this.tdk != null) {
            this.tdk.close();
            this.tdk = null;
        }
        boolean cn = e.cn(str2);
        boolean cn2 = e.cn(str);
        boolean cn3 = e.cn(str3);
        Object obj2 = (cn || !cn2) ? null : 1;
        this.tdm = a(str2, j, str4, f.cnW(), str3);
        String str5 = "MicroMsg.DBInit";
        String str6 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(cn);
        objArr[2] = Boolean.valueOf(cn2);
        objArr[3] = Boolean.valueOf(true);
        objArr[4] = Boolean.valueOf(this.tdm);
        objArr[5] = Boolean.valueOf(this.tdk != null);
        objArr[6] = Thread.currentThread().getName();
        x.i(str5, str6, objArr);
        if (this.tdk == null || this.tdk.getPath().equals(str3) || !cn3) {
            obj = null;
        } else {
            obj = 1;
            x.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        a((HashMap) hashMap, z, this.isNew);
        if (!cn2 && !cn3) {
            return true;
        }
        if (!(obj == null && obj2 == null)) {
            this.tdo = true;
        }
        if (obj != null) {
            this.aAL = g.u((str4 + j).getBytes()).substring(0, 7);
            gf(str3, this.aAL);
            com.tencent.mm.blink.a.i(201, 1);
        }
        if (obj2 != null) {
            boolean gf = gf(str, "");
            com.tencent.mm.blink.a.i(200, 1);
            return gf;
        } else if (this.tdk != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean gf(String str, String str2) {
        if (ge(str, str2)) {
            x.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            x.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(e.deleteFile(str)));
            return true;
        }
        x.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        return false;
    }

    private static void a(f fVar) {
        Cursor rawQueryWithFactory = (fVar.tdt != null ? fVar.tdt : fVar.tdu).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            return;
        }
        throw new SQLiteException("Cannot get count for sqlite_master");
    }

    private boolean a(String str, long j, String str2, boolean z, String str3) {
        Object obj;
        int i;
        if (this.tdk != null) {
            throw new AssertionError();
        }
        this.aAL = g.u((str2 + j).getBytes()).substring(0, 7);
        this.isNew = !FileOp.cn(str);
        try {
            this.tdk = f.s(str, this.aAL, z);
            a(this.tdk);
            return true;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseCorruptException) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String deviceID = q.getDeviceID(ad.getContext());
                if (!(deviceID == null || deviceID.equals(str2))) {
                    obj = null;
                    String substring = g.u((deviceID + j).getBytes()).substring(0, 7);
                    try {
                        this.tdk = f.s(str, substring, z);
                        a(this.tdk);
                        this.aAL = substring;
                        l.zh().set(258, deviceID);
                        f.mDy.a(181, 5, 1, false);
                        return true;
                    } catch (SQLiteException e2) {
                        if (e2 instanceof SQLiteDatabaseCorruptException) {
                            obj = 1;
                        }
                        if (!z) {
                            i = 42;
                        } else if (f.cnX()) {
                            i = 43;
                        } else {
                            i = 41;
                        }
                        f.mDy.a(181, (long) i, 1, true);
                        f.ZJ(str);
                        if (str.endsWith("EnMicroMsg.db")) {
                            f.ZJ(com.tencent.mm.kernel.g.Ei().dqp + "dbback/EnMicroMsg.db");
                        }
                        try {
                            this.tdk = f.s(str, this.aAL, z);
                            a(this.tdk);
                            this.isNew = true;
                            f.mDy.a(181, 6, 1, false);
                            return true;
                        } catch (SQLiteException e3) {
                            f.mDy.a(181, 7, 1, false);
                            if (this.tdk != null) {
                                this.tdk.close();
                                this.tdk = null;
                            }
                            this.aAL = null;
                            return false;
                        }
                    }
                }
                if (this.tdk == null && r2 != null) {
                    if (!z) {
                        i = 42;
                    } else if (f.cnX()) {
                        i = 43;
                    } else {
                        i = 41;
                    }
                    f.mDy.a(181, (long) i, 1, true);
                    f.ZJ(str);
                    if (str.endsWith("EnMicroMsg.db")) {
                        f.ZJ(com.tencent.mm.kernel.g.Ei().dqp + "dbback/EnMicroMsg.db");
                    }
                    this.tdk = f.s(str, this.aAL, z);
                    a(this.tdk);
                    this.isNew = true;
                    f.mDy.a(181, 6, 1, false);
                    return true;
                }
            } else if (str3 != null && str3.length() > 0) {
                this.isNew = !FileOp.cn(str3);
                try {
                    this.tdk = f.s(str3, this.aAL, z);
                    a(this.tdk);
                    f.mDy.a(181, 6, 1, false);
                    return true;
                } catch (SQLiteException e4) {
                    f.mDy.a(181, 7, 1, false);
                    if (this.tdk != null) {
                        this.tdk.close();
                        this.tdk = null;
                    }
                    this.aAL = null;
                    return false;
                }
            }
            if (this.tdk != null) {
                this.tdk.close();
                this.tdk = null;
            }
            this.aAL = null;
            return false;
        }
    }

    private boolean a(HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        int i;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        x.d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.tdl = this.tdk.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (d dVar : hashMap.values()) {
                    if (dVar.xb() == null) {
                        x.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", dVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + dVar.getClass().toString(), false);
                    }
                    for (String hashCode : dVar.xb()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.u(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.e.a.getValue(this.tdl, "createmd5");
                if (!bi.oW(str) && str3.equals(str)) {
                    x.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.tdk.getPath());
                    return true;
                }
            }
        }
        str = str3;
        this.tdk.execSQL("pragma auto_vacuum = 0 ");
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        int i2 = 0;
        this.tdk.beginTransaction();
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = i;
                for (String str4 : ((d) it.next()).xb()) {
                    try {
                        this.tdk.execSQL(str4);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = tdj.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            x.w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        long Ad = aVar.Ad();
        this.tdk.endTransaction();
        x.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(Ad), Long.valueOf(aVar.Ad()), Integer.valueOf(i));
        if (z) {
            com.tencent.mm.sdk.e.a.ap(this.tdl, "createmd5", str);
        }
        return true;
    }
}
