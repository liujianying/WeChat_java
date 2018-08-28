package com.tencent.mm.r;

import com.tencent.mm.g.c.bn;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends bn {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cgi";
        aVar.sKA.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cmdid";
        aVar.sKA.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "functionmsgid";
        aVar.sKA.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "functionmsgid";
        aVar.columns[3] = "version";
        aVar.sKA.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "preVersion";
        aVar.sKA.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryinterval";
        aVar.sKA.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportid";
        aVar.sKA.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "successkey";
        aVar.sKA.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "failkey";
        aVar.sKA.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "finalfailkey";
        aVar.sKA.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "custombuff";
        aVar.sKA.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "addMsg";
        aVar.sKA.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "status";
        aVar.sKA.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "needShow";
        aVar.sKA.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void b(by byVar) {
        if (byVar != null) {
            this.field_addMsg = byVar;
        }
    }
}
