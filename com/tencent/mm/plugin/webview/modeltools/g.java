package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends eu {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "host";
        aVar.sKA.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "expireTime";
        aVar.sKA.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
