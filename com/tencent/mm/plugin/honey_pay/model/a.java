package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.mm.g.c.cb;
import java.lang.reflect.Field;

public final class a extends cb {
    public static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "payMsgId";
        aVar.sKA.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "payMsgId";
        aVar.columns[1] = "msgId";
        aVar.sKA.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
