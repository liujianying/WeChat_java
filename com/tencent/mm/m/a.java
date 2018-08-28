package com.tencent.mm.m;

import com.tencent.mm.g.c.am;
import java.lang.reflect.Field;

public class a extends am {
    public static com.tencent.mm.sdk.e.c.a dhO;
    public static final String dhR = null;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgCount";
        aVar.sKA.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.sKA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[2] = "unReadCount";
        aVar.sKA.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatmode";
        aVar.sKA.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "status";
        aVar.sKA.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isSend";
        aVar.sKA.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "conversationTime";
        aVar.sKA.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "content";
        aVar.sKA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "msgType";
        aVar.sKA.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "customNotify";
        aVar.sKA.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showTips";
        aVar.sKA.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "flag";
        aVar.sKA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "digest";
        aVar.sKA.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "digestUser";
        aVar.sKA.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hasTrunc";
        aVar.sKA.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "parentRef";
        aVar.sKA.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrflag";
        aVar.sKA.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "editingMsg";
        aVar.sKA.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "atCount";
        aVar.sKA.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "sightTime";
        aVar.sKA.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "unReadMuteCount";
        aVar.sKA.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "lastSeq";
        aVar.sKA.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[22] = "UnDeliverCount";
        aVar.sKA.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "UnReadInvite";
        aVar.sKA.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "firstUnDeliverSeq";
        aVar.sKA.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.columns[25] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public a(String str) {
        setUsername(str);
    }

    public final void gf(int i) {
        eZ(this.field_attrflag | i);
    }

    public final void gg(int i) {
        eZ(this.field_attrflag & (i ^ -1));
    }

    public final boolean gh(int i) {
        return (this.field_attrflag & i) != 0;
    }
}
