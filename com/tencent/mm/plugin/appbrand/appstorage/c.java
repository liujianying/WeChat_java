package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;

public final class c extends i<b> {
    public static final String[] diD = new String[]{i.a(b.dhO, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private e fgu;

    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED
    }

    public c(e eVar) {
        super(eVar, b.dhO, "AppBrandKVData", null);
        this.fgu = eVar;
    }

    public final Object[] aT(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return new Object[]{a.MISSING_PARAMS};
        }
        b bVar = new b();
        bVar.field_key = A(str, str2, "__");
        if (super.b(bVar, new String[0])) {
            return new Object[]{a.NONE, bVar.field_data, bVar.field_dataType};
        }
        return new Object[]{a.NO_SUCH_KEY};
    }

    public final a f(String str, String str2, String str3, String str4) {
        Object obj = null;
        if (bi.oW(str) || bi.oW(str2)) {
            return a.MISSING_PARAMS;
        }
        String A = A(str, str2, "__");
        int length = (str3 == null ? 0 : str3.length()) + (str2 == null ? 0 : str2.length());
        int re = length - re(A);
        if (rd(str) + re >= com.tencent.mm.plugin.appbrand.config.i.rP(str)) {
            obj = 1;
        }
        if (obj != null) {
            return a.QUOTA_REACHED;
        }
        b bVar = new b();
        bVar.field_key = A;
        bVar.field_data = str3;
        bVar.field_dataType = str4;
        bVar.field_size = length;
        if (!super.a(bVar)) {
            return a.UNKNOWN;
        }
        ao(str, re);
        return a.NONE;
    }

    public final a aU(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return a.MISSING_PARAMS;
        }
        String A = A(str, str2, "__");
        ao(str, -re(A));
        b bVar = new b();
        bVar.field_key = A;
        super.a(bVar, new String[0]);
        return a.NONE;
    }

    public final void clear(String str) {
        super.fV("AppBrandKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandKVData", "key", str}));
    }

    public final Object[] rc(String str) {
        Cursor a = this.fgu.a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{(str + "__").replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0).replace(r9, ""));
        }
        a.close();
        int rd = rd(str);
        int rP = com.tencent.mm.plugin.appbrand.config.i.rP(str);
        return new Object[]{arrayList, Integer.valueOf(rd), Integer.valueOf(rP)};
    }

    private int rd(String str) {
        b bVar = new b();
        bVar.field_key = A(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        if (super.b(bVar, new String[0])) {
            return bi.getInt(bVar.field_data, 0);
        }
        return 0;
    }

    private int ao(String str, int i) {
        int max = Math.max(0, rd(str) + i);
        b bVar = new b();
        bVar.field_key = A(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        bVar.field_data = String.valueOf(max);
        super.a(bVar);
        return max;
    }

    private int re(String str) {
        Cursor a = this.fgu.a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    private static String A(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
