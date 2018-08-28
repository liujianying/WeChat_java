package com.tencent.mm.plugin.appbrand.game.a.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c extends i<b> {
    public static final String[] dzV = new String[]{i.a(b.dhO, "WxagGameInfo")};
    private final boolean fAQ;

    public c(e eVar) {
        super(eVar, b.dhO, "WxagGameInfo", null);
        this.fAQ = eVar != null;
        if (!this.fAQ) {
            x.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
    }

    public final List<b> agq() {
        List<b> list = null;
        if (this.fAQ) {
            Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"WxagGameInfo"}), new String[0]);
            x.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    b bVar = new b();
                    bVar.d(rawQuery);
                    list.add(bVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "no record");
            }
        }
        return list;
    }

    public final b sO(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WxagGameInfo", "RecordId"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            b bVar = new b();
            bVar.d(rawQuery);
            rawQuery.close();
            return bVar;
        }
        x.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final void c(a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.r.c.Em().lnJ.getLooper());
    }

    public final boolean d(List<a> list, boolean z) {
        if (!this.fAQ || bi.cX(list)) {
            return false;
        }
        List arrayList = new ArrayList();
        for (a aVar : list) {
            a(aVar, false);
            arrayList.add(aVar.dfX);
        }
        if (z) {
            b("batch", 2, arrayList);
        }
        x.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", new Object[]{Integer.valueOf(list.size()), Boolean.valueOf(false)});
        return true;
    }

    public final boolean U(String str, boolean z) {
        boolean z2 = false;
        if (this.fAQ && !bi.oW(str)) {
            b bVar = new b();
            bVar.field_RecordId = str;
            z2 = super.a(bVar, new String[0]);
            if (z2 && z) {
                b("single", 5, str);
            }
        }
        return z2;
    }

    public final boolean an(List<String> list) {
        if (!this.fAQ || bi.cX(list)) {
            return false;
        }
        for (String U : list) {
            U(U, false);
        }
        b("batch", 5, list);
        return true;
    }

    public final boolean a(a aVar, boolean z) {
        boolean z2 = false;
        if (this.fAQ && aVar != null) {
            b bVar;
            b bVar2;
            boolean z3;
            String str = aVar.jQb;
            int i = aVar.fig;
            if (this.fAQ) {
                Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[]{"WxagGameInfo", "AppId", "debugType"}), new String[]{str, String.valueOf(i)});
                if (rawQuery.moveToFirst()) {
                    bVar = new b();
                    bVar.d(rawQuery);
                    rawQuery.close();
                    bVar2 = bVar;
                } else {
                    rawQuery.close();
                    bVar2 = null;
                }
            } else {
                bVar2 = null;
            }
            if (bVar2 == null || !bVar2.field_isSync) {
                z3 = true;
            } else {
                z3 = false;
            }
            x.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", new Object[]{Boolean.valueOf(z3)});
            if (z3) {
                if (this.fAQ && bVar2 != null) {
                    super.a(bVar2, new String[0]);
                }
                bVar = new b();
                if (bi.oW(aVar.dfX)) {
                    str = aVar.hbL;
                    i = aVar.fig;
                    aVar.dfX = String.valueOf(String.format(Locale.US, "%s|%d", new Object[]{str, Integer.valueOf(i)}).hashCode());
                }
                bVar.field_RecordId = aVar.dfX;
                bVar.field_AppId = aVar.jQb;
                bVar.field_AppName = aVar.jSv;
                bVar.field_UserName = aVar.hbL;
                bVar.field_IconUrl = aVar.jPG;
                bVar.field_BriefIntro = aVar.jQp;
                bVar.field_isSync = false;
                bVar.field_createTime = System.currentTimeMillis();
                z2 = b(bVar);
                if (z2 && z) {
                    b("single", 2, bVar.field_RecordId);
                }
            }
        }
        return z2;
    }
}
