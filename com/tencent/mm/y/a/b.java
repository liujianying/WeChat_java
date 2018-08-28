package com.tencent.mm.y.a;

import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends fc {
    public static a dzU;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shareKeyHash";
        aVar.sKA.put("shareKeyHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "shareKeyHash";
        aVar.columns[1] = "btnState";
        aVar.sKA.put("btnState", "INTEGER");
        stringBuilder.append(" btnState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgState";
        aVar.sKA.put("msgState", "INTEGER");
        stringBuilder.append(" msgState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "content";
        aVar.sKA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "contentColor";
        aVar.sKA.put("contentColor", "TEXT");
        stringBuilder.append(" contentColor TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "updatePeroid";
        aVar.sKA.put("updatePeroid", "INTEGER");
        stringBuilder.append(" updatePeroid INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    protected final a AX() {
        return dzU;
    }
}
