package com.tencent.mm.ac.a;

import com.tencent.mm.g.c.v;
import java.lang.reflect.Field;

public final class a extends v {
    protected static com.tencent.mm.sdk.e.c.a dhO;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatId";
        aVar.sKA.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "bizChatId";
        aVar.columns[1] = "brandUserName";
        aVar.sKA.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "unReadCount";
        aVar.sKA.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "newUnReadCount";
        aVar.sKA.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastMsgID";
        aVar.sKA.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "lastMsgTime";
        aVar.sKA.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.sKA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "digest";
        aVar.sKA.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "digestUser";
        aVar.sKA.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "atCount";
        aVar.sKA.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "editingMsg";
        aVar.sKA.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatType";
        aVar.sKA.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "status";
        aVar.sKA.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "isSend";
        aVar.sKA.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgType";
        aVar.sKA.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "msgCount";
        aVar.sKA.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "flag";
        aVar.sKA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
