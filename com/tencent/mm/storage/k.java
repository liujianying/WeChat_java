package com.tencent.mm.storage;

import com.tencent.mm.g.c.t;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends t {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgListDataId";
        aVar.sKA.put("msgListDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgListDataId";
        aVar.columns[1] = "sessionName";
        aVar.sKA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
