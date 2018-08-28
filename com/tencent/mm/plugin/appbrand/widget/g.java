package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends aq {
    public static a dzU;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.sKA.put("id", "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cacheKey";
        aVar.sKA.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "data";
        aVar.sKA.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "interval";
        aVar.sKA.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    protected final a AX() {
        return dzU;
    }
}
