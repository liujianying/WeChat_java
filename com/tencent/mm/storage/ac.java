package com.tencent.mm.storage;

import com.tencent.mm.g.c.aj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ac extends aj {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "cmdbuf";
        aVar.sKA.put("cmdbuf", "BLOB default '' ");
        stringBuilder.append(" cmdbuf BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
