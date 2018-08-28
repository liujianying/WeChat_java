package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.g.c.dl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends dl {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroom";
        aVar.sKA.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "daySec";
        aVar.sKA.put("daySec", "TEXT");
        stringBuilder.append(" daySec TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.sKA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "isMute";
        aVar.sKA.put("isMute", "INTEGER");
        stringBuilder.append(" isMute INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "unReadCount";
        aVar.sKA.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "sendCount";
        aVar.sKA.put("sendCount", "INTEGER");
        stringBuilder.append(" sendCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "enterCount";
        aVar.sKA.put("enterCount", "INTEGER");
        stringBuilder.append(" enterCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "disRedDotCount";
        aVar.sKA.put("disRedDotCount", "INTEGER");
        stringBuilder.append(" disRedDotCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "stayTime";
        aVar.sKA.put("stayTime", "LONG");
        stringBuilder.append(" stayTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "score";
        aVar.sKA.put("score", "FLOAT");
        stringBuilder.append(" score FLOAT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final String toString() {
        return String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", new Object[]{this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.sKx)});
    }
}
