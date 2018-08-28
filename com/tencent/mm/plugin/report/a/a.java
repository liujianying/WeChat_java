package com.tencent.mm.plugin.report.a;

import com.tencent.mm.g.c.ap;
import java.lang.reflect.Field;

public final class a extends ap {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bakLogId";
        aVar.sKA.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "valueStr";
        aVar.sKA.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
