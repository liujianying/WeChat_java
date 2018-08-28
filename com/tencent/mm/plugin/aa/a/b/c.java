package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.g.c.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends b {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "billNo";
        aVar.sKA.put("billNo", "TEXT PRIMARY KEY ");
        stringBuilder.append(" billNo TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "billNo";
        aVar.columns[1] = "insertmsg";
        aVar.sKA.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "localMsgId";
        aVar.sKA.put("localMsgId", "LONG");
        stringBuilder.append(" localMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.sKA.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
