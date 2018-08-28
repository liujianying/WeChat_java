package com.tencent.mm.ac.a;

import com.tencent.mm.g.c.x;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends x {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "brandUserName";
        aVar.sKA.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "brandUserName";
        aVar.columns[1] = "userId";
        aVar.sKA.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
