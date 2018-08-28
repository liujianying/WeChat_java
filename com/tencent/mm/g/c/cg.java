package com.tencent.mm.g.c;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cg extends c {
    private static final int cDT = "logId".hashCode();
    private static final int cDU = "liftTime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    public long field_liftTime;
    public int field_logId;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logId";
        aVar.sKA.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "logId";
        aVar.columns[1] = "liftTime";
        aVar.sKA.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }
}
