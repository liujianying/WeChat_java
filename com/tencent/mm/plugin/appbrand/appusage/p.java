package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.d.b;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class p extends j {
    public static final String[] dzV = new String[]{i.a(a.dzU, "AppBrandLauncherLayoutItem")};
    final h fhY;
    final b fms;
    public final c fmt = new c(this, (byte) 0);

    public final class c {
        /* synthetic */ c(p pVar, byte b) {
            this();
        }

        private c() {
        }

        public final ArrayList<k> bN(long j) {
            return p.f(p.this.fhY.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
        }
    }

    public p(h hVar) {
        this.fhY = hVar;
        this.fms = new b(hVar);
    }

    public final void c(a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.r.c.Em().lnJ.getLooper());
    }

    public final boolean ar(String str, int i) {
        boolean z = true;
        if (bi.oW(str)) {
            return false;
        }
        Cursor b = this.fhY.b(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (b == null) {
            return false;
        }
        if (!b.moveToFirst()) {
            z = false;
        } else if (b.getInt(0) <= 0) {
            z = false;
        }
        b.close();
        return z;
    }

    final Cursor a(String[] strArr, int i, int i2) {
        return this.fhY.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
    }

    private static ArrayList<k> f(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList<k> arrayList;
        if (cursor.moveToFirst()) {
            Collection linkedList = new LinkedList();
            a aVar = new a();
            do {
                aVar.d(cursor);
                if (!bi.oW(aVar.field_brandId)) {
                    linkedList.add(q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
        } else {
            arrayList = new ArrayList();
        }
        cursor.close();
        return arrayList;
    }

    public final ArrayList<k> adf() {
        return f(a(null, 200, 0));
    }

    public final k rn(String str) {
        k kVar = null;
        if (!bi.oW(str)) {
            Cursor query = this.fhY.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    a aVar = new a();
                    aVar.d(query);
                    if (!bi.oW(aVar.field_brandId)) {
                        kVar = q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime);
                    }
                }
                query.close();
            }
        }
        return kVar;
    }

    public final List<String> ro(String str) {
        List<String> linkedList = new LinkedList();
        if (!bi.oW(str)) {
            Cursor query = this.fhY.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, boolean z, boolean z2, int i2, int i3, String str2) {
        if (bi.oW(str) || 999 == i) {
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor b = this.fhY.b(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (b == null) {
            j = 0;
        } else {
            j = 0;
            if (b.moveToFirst()) {
                j = b.getLong(0);
            }
            b.close();
        }
        long max = Math.max(j + 1, bi.VE());
        int x = x(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.fhY.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(x)}) > 0 ? 1 : null;
        if (obj != null) {
            b("single", 3, String.valueOf(x));
        }
        if (obj == null) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i;
            boolean a = a(aVar);
            if (a) {
                b("single", 2, String.valueOf(x));
            }
            z3 = a;
            z4 = a;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z && d.a.jC(i)) {
            Pair v = ((b) e.x(b.class)).v(str, 3, i2);
            if (((Boolean) v.first).booleanValue()) {
                x.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[]{str, Integer.valueOf(i2)});
                int i4 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) ((Integer) v.second).intValue(), 165);
            } else {
                new s(i2, z2, i, 2, 1, str, i3, str2).KM();
            }
        }
        if (z4) {
            com.tencent.mm.plugin.appbrand.appcache.q.ae(str, i);
        }
        if (z3) {
            adg();
        }
        if (z4) {
            ((g) e.x(g.class)).a(str, i, g$a.USAGE_LIST);
        }
        return z4;
    }

    private void adg() {
        int i;
        int i2 = 0;
        Cursor b = this.fhY.b(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (b == null) {
            i = 0;
        } else {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            } else {
                i = 0;
            }
            b.close();
        }
        if (i > 200) {
            b = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, 200);
            if (b != null) {
                List<String> linkedList = new LinkedList();
                List arrayList = new ArrayList(i - 200);
                List arrayList2 = new ArrayList(i - 200);
                if (b.moveToFirst()) {
                    do {
                        linkedList.add(String.valueOf(b.getInt(0)));
                        arrayList.add(b.getString(1));
                        arrayList2.add(Integer.valueOf(b.getInt(2)));
                    } while (b.moveToNext());
                }
                b.close();
                if (!bi.cX(linkedList)) {
                    String rW;
                    long dO = this.fhY.dO(Thread.currentThread().getId());
                    for (String rW2 : linkedList) {
                        this.fhY.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{rW2});
                    }
                    this.fhY.gp(dO);
                    List arrayList3 = new ArrayList(arrayList.size());
                    List arrayList4 = new ArrayList(arrayList.size());
                    while (i2 < arrayList.size()) {
                        rW2 = q.rW((String) arrayList.get(i2));
                        if (!bi.oW(rW2)) {
                            arrayList3.add(rW2);
                            arrayList4.add(arrayList2.get(i2));
                        }
                        i2++;
                    }
                    if (e.abi() != null) {
                        e.abi().c(arrayList3, arrayList4);
                    }
                    b("batch", 5, linkedList);
                }
            }
        }
    }

    public final boolean a(String str, int i, boolean z, int i2, int i3, String str2) {
        boolean a = a(str, i, true, z, i2, i3, str2);
        if (a) {
            b.rk(str2);
        }
        return a;
    }

    final boolean a(a aVar) {
        if (bi.oW(aVar.field_brandId)) {
            return false;
        }
        long insert = this.fhY.insert("AppBrandLauncherLayoutItem", "", aVar.wH());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            return true;
        }
        return false;
    }

    static int x(String str, int i, int i2) {
        return String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
    }
}
