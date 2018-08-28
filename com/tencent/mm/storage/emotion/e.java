package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends au {
    protected static a dhO;

    public e(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    protected final a AX() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "groupID";
        aVar.sKA.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "desc";
        aVar.sKA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }
}
