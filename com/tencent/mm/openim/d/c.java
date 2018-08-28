package com.tencent.mm.openim.d;

import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends ct {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.sKA.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "language";
        aVar.sKA.put("language", "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appRec";
        aVar.sKA.put("appRec", "BLOB");
        stringBuilder.append(" appRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.sKA.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "acctTypeId";
        aVar.sKA.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
