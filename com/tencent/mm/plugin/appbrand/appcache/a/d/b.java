package com.tencent.mm.plugin.appbrand.appcache.a.d;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public class b extends i<a> {
    public static final String[] dzV = new String[]{i.a(a.dzU, "PredownloadBlockCgiRequest")};
    private final e fgu;

    public b(e eVar) {
        super(eVar, a.dzU, "PredownloadBlockCgiRequest", a.ciG);
        this.fgu = eVar;
    }

    public final Pair<Boolean, Integer> v(String str, int i, int i2) {
        return c("username", str, i, i2);
    }

    public final Pair<Boolean, Integer> w(String str, int i, int i2) {
        return c("appId", str, i, i2);
    }

    private Pair<Boolean, Integer> c(String str, String str2, int i, int i2) {
        int i3 = -1;
        long VE = bi.VE();
        String str3 = "select reportId from PredownloadBlockCgiRequest where " + str + "=? and startTime<" + VE + " and " + VE + "<endTime and cgiList like '%;" + i + ";%' and sceneList like '%;" + i2 + ";%'";
        Cursor rawQuery = this.fgu.rawQuery(str3, new String[]{str2});
        if (rawQuery == null || rawQuery.isClosed()) {
            return Pair.create(Boolean.valueOf(false), Integer.valueOf(-1));
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        if (moveToFirst) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return Pair.create(Boolean.valueOf(moveToFirst), Integer.valueOf(i3));
    }
}
