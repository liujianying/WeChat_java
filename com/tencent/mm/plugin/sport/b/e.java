package com.tencent.mm.plugin.sport.b;

import com.tencent.mm.g.c.ea;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends ea implements Comparable<e> {
    public static a dhO;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        if (this.field_timestamp > eVar.field_timestamp) {
            return 1;
        }
        return this.field_timestamp < eVar.field_timestamp ? -1 : 0;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.sKA.put("id", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "id";
        aVar.columns[1] = "date";
        aVar.sKA.put("date", "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "step";
        aVar.sKA.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "timestamp";
        aVar.sKA.put("timestamp", "LONG");
        stringBuilder.append(" timestamp LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
