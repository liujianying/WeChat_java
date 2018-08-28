package com.tencent.mm.plugin.j.b;

import android.database.Cursor;
import com.tencent.mm.g.c.ez;
import java.lang.reflect.Field;

public final class a extends ez {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.sKA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgType";
        aVar.sKA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgSubType";
        aVar.sKA.put("msgSubType", "INTEGER");
        stringBuilder.append(" msgSubType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "path";
        aVar.sKA.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "size";
        aVar.sKA.put("size", "LONG");
        stringBuilder.append(" size LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgtime";
        aVar.sKA.put("msgtime", "LONG");
        stringBuilder.append(" msgtime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
    }

    public final String toString() {
        return "{  sys row id: " + this.sKx + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
    }
}
