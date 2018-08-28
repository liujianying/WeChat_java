package com.tencent.mm.plugin.freewifi.g;

import com.tencent.mm.g.c.bm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bm {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.sKA.put("id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "id";
        aVar.columns[1] = "protocolNumber";
        aVar.sKA.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "logContent";
        aVar.sKA.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
