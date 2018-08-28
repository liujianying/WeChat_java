package com.tencent.mm.storage;

import com.tencent.mm.g.c.u;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends u {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "sessionName";
        aVar.sKA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "startTime";
        aVar.sKA.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "endTime";
        aVar.sKA.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
