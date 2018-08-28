package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.g.c.j;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends j {
    public static final a dzU;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.sKA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "key";
        aVar.columns[1] = "value";
        aVar.sKA.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    protected final a AX() {
        return dzU;
    }
}
