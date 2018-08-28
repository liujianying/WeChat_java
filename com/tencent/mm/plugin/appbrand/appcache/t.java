package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class t extends cz {
    static final String[] fgs = new String[]{"key", "version"};
    static final a fgt;

    protected final a AX() {
        return fgt;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.sKA.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.sKA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "scene";
        aVar.sKA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        fgt = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = fgs;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = fgt;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
    }
}
