package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.g.c.ef;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class x extends ef {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.sKA.put("canvasId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" canvasId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.sKA.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "canvasExt";
        aVar.sKA.put("canvasExt", "TEXT");
        stringBuilder.append(" canvasExt TEXT");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
