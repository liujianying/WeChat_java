package com.tencent.mm.plugin.boots.a;

import com.tencent.mm.g.c.e;
import java.lang.reflect.Field;

public final class a extends e {
    public static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.sKA.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.sKz = "key";
        aVar.columns[1] = "mau";
        aVar.sKA.put("mau", "INTEGER");
        stringBuilder.append(" mau INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "dau";
        aVar.sKA.put("dau", "INTEGER");
        stringBuilder.append(" dau INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "useTime";
        aVar.sKA.put("useTime", "LONG");
        stringBuilder.append(" useTime LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
