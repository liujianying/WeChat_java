package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.g.c.dj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends dj {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "transferId";
        aVar.sKA.put("transferId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" transferId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "transferId";
        aVar.columns[1] = "locaMsgId";
        aVar.sKA.put("locaMsgId", "LONG");
        stringBuilder.append(" locaMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveStatus";
        aVar.sKA.put("receiveStatus", "INTEGER default '-1' ");
        stringBuilder.append(" receiveStatus INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "isSend";
        aVar.sKA.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
