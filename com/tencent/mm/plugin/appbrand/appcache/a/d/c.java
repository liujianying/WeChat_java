package com.tencent.mm.plugin.appbrand.appcache.a.d;

import com.tencent.mm.g.c.dc;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends dc implements b {
    static final a dzU;
    static final String[] fgs = new String[]{"appId", "type", "version"};

    protected final a AX() {
        return dzU;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.sKy = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.sKA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "retryTimes";
        aVar.sKA.put("retryTimes", "INTEGER");
        stringBuilder.append(" retryTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "retriedCount";
        aVar.sKA.put("retriedCount", "INTEGER");
        stringBuilder.append(" retriedCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryInterval";
        aVar.sKA.put("retryInterval", "LONG");
        stringBuilder.append(" retryInterval LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "networkType";
        aVar.sKA.put("networkType", "INTEGER");
        stringBuilder.append(" networkType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "pkgMd5";
        aVar.sKA.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastRetryTime";
        aVar.sKA.put("lastRetryTime", "LONG");
        stringBuilder.append(" lastRetryTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "firstTimeTried";
        aVar.sKA.put("firstTimeTried", "INTEGER");
        stringBuilder.append(" firstTimeTried INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reportId";
        aVar.sKA.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[11] = "rowid";
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
