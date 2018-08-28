package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.c.ag;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends ag {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "code_id";
        aVar.sKA.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "card_id";
        aVar.sKA.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "code";
        aVar.sKA.put("code", "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
