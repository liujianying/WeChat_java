package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends r {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "flag";
        aVar.sKA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "sortId";
        aVar.sKA.put("sortId", "INTEGER default '0' ");
        stringBuilder.append(" sortId INTEGER default '0' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
