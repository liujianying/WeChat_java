package com.tencent.mm.storage;

import com.tencent.mm.g.c.ak;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ad extends ak {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelID";
        aVar.sKA.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "labelID";
        aVar.columns[1] = "labelName";
        aVar.sKA.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "labelPYFull";
        aVar.sKA.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "labelPYShort";
        aVar.sKA.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isTemporary";
        aVar.sKA.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
