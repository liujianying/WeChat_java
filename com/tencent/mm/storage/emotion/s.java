package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class s extends du {
    protected static a dhO;

    protected final a AX() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.sKA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "key";
        aVar.columns[1] = "position";
        aVar.sKA.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public s(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        return stringBuilder.toString();
    }
}
