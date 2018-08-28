package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.o;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class al extends o {
    static final a dzU;
    public static final String[] fhI = new String[]{"appId", "version", "debugType"};

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.sKA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionMd5";
        aVar.sKA.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "versionState";
        aVar.sKA.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.sKA.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "debugType";
        aVar.sKA.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadURL";
        aVar.sKA.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "startTime";
        aVar.sKA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "endTime";
        aVar.sKA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = fhI;
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

    protected final a AX() {
        return dzU;
    }
}
