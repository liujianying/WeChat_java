package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends et {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.sKA.put("recordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" recordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "recordId";
        aVar.columns[1] = "link";
        aVar.sKA.put("link", "TEXT");
        stringBuilder.append(" link TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.sKA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "source";
        aVar.sKA.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "imgUrl";
        aVar.sKA.put("imgUrl", "TEXT");
        stringBuilder.append(" imgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.sKA.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
