package com.tencent.mm.plugin.order.b;

import com.tencent.mm.g.c.cw;
import java.lang.reflect.Field;

public final class a extends cw {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgId";
        aVar.columns[1] = "msgContentXml";
        aVar.sKA.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.sKA.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
