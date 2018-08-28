package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends cd {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrId";
        aVar.sKA.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "svrId";
        aVar.columns[1] = "isRead";
        aVar.sKA.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.sKA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "content";
        aVar.sKA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pushTime";
        aVar.sKA.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgType";
        aVar.sKA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "descUrl";
        aVar.sKA.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
