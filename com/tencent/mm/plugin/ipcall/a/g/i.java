package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.c.ce;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends ce {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "countryCode";
        aVar.sKA.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "countryCode";
        aVar.columns[1] = "callTimeCount";
        aVar.sKA.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "lastCallTime";
        aVar.sKA.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
