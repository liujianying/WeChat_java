package com.tencent.mm.storage;

import com.tencent.mm.g.c.s;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends s {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceId";
        aVar.sKA.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "sessionName";
        aVar.sKA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "moveTime";
        aVar.sKA.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
