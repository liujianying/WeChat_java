package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends av {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "designerIDAndType";
        aVar.sKA.put("designerIDAndType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "designerIDAndType";
        aVar.columns[1] = "content";
        aVar.sKA.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return null;
    }
}
