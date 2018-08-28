package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.g.c.ew;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class af extends ew {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.sKA.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "recordId";
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "domin";
        aVar.sKA.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "key";
        aVar.sKA.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "value";
        aVar.sKA.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
