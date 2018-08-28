package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.g.c.fd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class l extends fd {
    public static a dzU;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.sKA.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "openDebug";
        aVar.sKA.put("openDebug", "INTEGER");
        stringBuilder.append(" openDebug INTEGER");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    protected final a AX() {
        return dzU;
    }
}
