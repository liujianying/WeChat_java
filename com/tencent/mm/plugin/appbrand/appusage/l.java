package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;

public final class l extends j {
    public static final String[] dzV = new String[]{i.a(a.dzU, "AppBrandStarApp")};
    public final h fhY;
    public final c fme;
    public volatile int fmf = 10;

    public l(h hVar) {
        this.fhY = hVar;
        this.fme = new c(hVar);
    }

    public final void c(a aVar) {
        a(aVar, c.Em().lnJ.getLooper());
    }

    public final b<ArrayList> jM(int i) {
        b<ArrayList> bVar = null;
        if (i == 0) {
            i = b.fmk;
        }
        Cursor query = this.fhY.query("AppBrandStarApp", new String[]{"username", "versionType"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset 0", new Object[]{"updateTime", Integer.valueOf(this.fmf)}));
        if (query != null) {
            if (b.fml == i) {
                query.close();
            } else {
                query.close();
            }
            Collection linkedList = new LinkedList();
            a aVar = new a();
            while (true) {
                aVar.d(query);
                linkedList.add(q.a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{aVar.field_username, Integer.valueOf(aVar.field_versionType)}), aVar.field_username, aVar.field_versionType, -1));
                if (b.fml == i) {
                    if (!query.moveToPrevious()) {
                        break;
                    }
                } else if (!query.moveToNext()) {
                    break;
                }
            }
            bVar = new ArrayList(linkedList.size());
            bVar.addAll(linkedList);
            query.close();
        }
        return bVar;
    }

    public final boolean aq(String str, int i) {
        Cursor cursor = null;
        if (!bi.oW(str)) {
            cursor = this.fhY.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        return moveToFirst;
    }

    public final boolean g(String str, int i, boolean z) {
        if (bi.oW(str)) {
            return false;
        }
        boolean z2;
        s sVar;
        a aVar = new a();
        aVar.field_username = str;
        aVar.field_versionType = i;
        if (this.fme.b(aVar, new String[]{"versionType", "username"})) {
            this.fme.a(aVar, false, a.fgs);
            if (aq(str, i)) {
                z2 = false;
                if (z2 && z) {
                    sVar = new s(1003, false, i, 1, 2, str, 1, null);
                    sVar.fmC = new 2(this, aVar, str, i);
                    sVar.KM();
                }
                return z2;
            }
            b("single", 5, aVar);
        }
        z2 = true;
        sVar = new s(1003, false, i, 1, 2, str, 1, null);
        sVar.fmC = new 2(this, aVar, str, i);
        sVar.KM();
        return z2;
    }
}
