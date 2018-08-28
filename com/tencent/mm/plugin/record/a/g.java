package com.tencent.mm.plugin.record.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.c.di;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends di implements b {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.sKA.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "localId";
        aVar.columns[1] = "msgId";
        aVar.sKA.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "oriMsgId";
        aVar.sKA.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUser";
        aVar.sKA.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = SlookSmartClipMetaTag.TAG_TYPE_TITLE;
        aVar.sKA.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "desc";
        aVar.sKA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "dataProto";
        aVar.sKA.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "type";
        aVar.sKA.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "status";
        aVar.sKA.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "favFrom";
        aVar.sKA.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final int bqo() {
        return this.field_localId;
    }
}
