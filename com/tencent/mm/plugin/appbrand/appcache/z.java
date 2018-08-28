package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.dg;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends dg implements b {
    static final a dzU;
    static final String[] fgs = new String[]{"appId", "appVersion"};

    protected final a AX() {
        return dzU;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appVersion";
        aVar.sKA.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "decryptKey";
        aVar.sKA.put("decryptKey", "TEXT");
        stringBuilder.append(" decryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.sKA.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "reportId";
        aVar.sKA.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = fgs;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = dzU;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
    }

    public final String[] getKeys() {
        return fgs;
    }
}
