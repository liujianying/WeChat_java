package com.tencent.mm.plugin.expt.c;

import com.tencent.mm.g.c.ba;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends ba {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "exptKey";
        aVar.sKA.put("exptKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" exptKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "exptKey";
        aVar.columns[1] = "exptId";
        aVar.sKA.put("exptId", "INTEGER");
        stringBuilder.append(" exptId INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
