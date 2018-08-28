package com.tencent.mm.storage;

import com.tencent.mm.g.c.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class a extends c {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "abtestkey";
        aVar.sKA.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "abtestkey";
        aVar.columns[1] = "value";
        aVar.sKA.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.sKA.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.sKA.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.sKA.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.sKA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.sKA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "noReport";
        aVar.sKA.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public final boolean isValid() {
        long VE = bi.VE();
        return VE >= this.field_startTime && VE < this.field_endTime;
    }
}
