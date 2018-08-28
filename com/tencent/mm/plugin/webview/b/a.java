package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.g.c.es;
import java.lang.reflect.Field;

public final class a extends es {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appIdKey";
        aVar.sKA.put("appIdKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "appIdKey";
        aVar.columns[2] = "value";
        aVar.sKA.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "weight";
        aVar.sKA.put("weight", "TEXT");
        stringBuilder.append(" weight TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expireTime";
        aVar.sKA.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.sKA.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "size";
        aVar.sKA.put("size", "LONG");
        stringBuilder.append(" size LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
