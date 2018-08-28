package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.g.c.i;
import java.lang.reflect.Field;

public final class a extends i {
    static final com.tencent.mm.sdk.e.c.a dzU;

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dzU;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }
}
