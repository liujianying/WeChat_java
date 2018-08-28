package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends aw {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.sKA.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "productID";
        aVar.columns[1] = "content";
        aVar.sKA.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lan";
        aVar.sKA.put("lan", "TEXT default '' ");
        stringBuilder.append(" lan TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
