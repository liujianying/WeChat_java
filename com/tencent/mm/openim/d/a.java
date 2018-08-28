package com.tencent.mm.openim.d;

import com.tencent.mm.g.c.cs;
import java.lang.reflect.Field;

public final class a extends cs {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "acctTypeId";
        aVar.sKA.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "language";
        aVar.sKA.put("language", "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "accTypeRec";
        aVar.sKA.put("accTypeRec", "BLOB");
        stringBuilder.append(" accTypeRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.sKA.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
