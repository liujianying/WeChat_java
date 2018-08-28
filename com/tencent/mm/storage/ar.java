package com.tencent.mm.storage;

import com.tencent.mm.g.c.bb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ar extends bb {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "talker";
        aVar.sKA.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "talker";
        aVar.columns[1] = "encryptTalker";
        aVar.sKA.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "displayName";
        aVar.sKA.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "state";
        aVar.sKA.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastModifiedTime";
        aVar.sKA.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isNew";
        aVar.sKA.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "addScene";
        aVar.sKA.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "fmsgSysRowId";
        aVar.sKA.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "fmsgIsSend";
        aVar.sKA.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "fmsgType";
        aVar.sKA.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "fmsgContent";
        aVar.sKA.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "recvFmsgType";
        aVar.sKA.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "contentFromUsername";
        aVar.sKA.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "contentNickname";
        aVar.sKA.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contentPhoneNumMD5";
        aVar.sKA.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "contentFullPhoneNumMD5";
        aVar.sKA.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentVerifyContent";
        aVar.sKA.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
