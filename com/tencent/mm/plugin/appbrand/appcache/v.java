package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.da;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class v extends da {
    static final String[] fgs = new String[]{"appId", "type"};
    static final a fgt;

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "hit";
        aVar.sKA.put("hit", "INTEGER");
        stringBuilder.append(" hit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "hitTimeMS";
        aVar.sKA.put("hitTimeMS", "LONG");
        stringBuilder.append(" hitTimeMS LONG");
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

    protected final a AX() {
        return fgt;
    }
}
