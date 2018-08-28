package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.c.ao;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends ao {
    static final String[] fgs = new String[]{"appId", "versionType"};
    static final a fgt;

    protected final a AX() {
        return null;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "versionType";
        aVar.sKA.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "extJson";
        aVar.sKA.put("extJson", "TEXT");
        stringBuilder.append(" extJson TEXT");
        aVar.columns[3] = "rowid";
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
