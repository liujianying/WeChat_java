package com.tencent.mm.plugin.appbrand.appcache.a.d;

import com.tencent.mm.g.c.de;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends de implements b {
    static final a dzU;
    static final String[] fgs = new String[]{"appId", "scene"};

    protected final a AX() {
        return dzU;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.sKA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "launchProtoBlob";
        aVar.sKA.put("launchProtoBlob", "BLOB");
        stringBuilder.append(" launchProtoBlob BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "startTime";
        aVar.sKA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "endTime";
        aVar.sKA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "reportId";
        aVar.sKA.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        aVar.columns[6] = "rowid";
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
