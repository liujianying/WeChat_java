package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.ay;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends ay {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "prodcutID";
        aVar.sKA.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "prodcutID";
        aVar.columns[1] = "totalCount";
        aVar.sKA.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "continuCount";
        aVar.sKA.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "flag";
        aVar.sKA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "modifyTime";
        aVar.sKA.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "showTipsTime";
        aVar.sKA.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "setFlagTime";
        aVar.sKA.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return null;
    }
}
