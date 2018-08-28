package com.tencent.mm.storage;

import com.tencent.mm.g.c.ec;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bs extends ec {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tableHash";
        aVar.sKA.put("tableHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "tableHash";
        aVar.columns[1] = "tableSQLMD5";
        aVar.sKA.put("tableSQLMD5", "TEXT");
        stringBuilder.append(" tableSQLMD5 TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
