package com.tencent.mm.storage;

import com.tencent.mm.g.c.bt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class aw extends bt {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "originSvrId";
        aVar.sKA.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "originSvrId";
        aVar.columns[1] = "newMsgId";
        aVar.sKA.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "fromUserName";
        aVar.sKA.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUserName";
        aVar.sKA.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.sKA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "content";
        aVar.sKA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgSource";
        aVar.sKA.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "msgSeq";
        aVar.sKA.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "flag";
        aVar.sKA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.sKA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.sKA.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.sKA.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.sKA.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
