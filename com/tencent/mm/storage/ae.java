package com.tencent.mm.storage;

import com.tencent.mm.g.c.al;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ae extends al {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelId";
        aVar.sKA.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "contactName";
        aVar.sKA.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
