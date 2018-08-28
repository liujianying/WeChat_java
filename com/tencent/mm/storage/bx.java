package com.tencent.mm.storage;

import com.tencent.mm.g.c.eh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class bx extends eh {
    protected static a dhO;

    protected final a AX() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgId";
        aVar.columns[1] = "cmsgId";
        aVar.sKA.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "content";
        aVar.sKA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public final void Zr(String str) {
        if (!bi.oW(str)) {
            this.field_cmsgId = str;
        }
    }
}
