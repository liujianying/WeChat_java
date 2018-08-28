package com.tencent.mm.ac;

import com.tencent.mm.g.c.z;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends z {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.sKA.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "userName";
        aVar.columns[1] = "qyUin";
        aVar.sKA.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "userUin";
        aVar.sKA.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "userFlag";
        aVar.sKA.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wwExposeTimes";
        aVar.sKA.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wwMaxExposeTimes";
        aVar.sKA.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wwCorpId";
        aVar.sKA.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "wwUserVid";
        aVar.sKA.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "userType";
        aVar.sKA.put("userType", "INTEGER");
        stringBuilder.append(" userType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "chatOpen";
        aVar.sKA.put("chatOpen", "INTEGER");
        stringBuilder.append(" chatOpen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "wwUnreadCnt";
        aVar.sKA.put("wwUnreadCnt", "INTEGER default '0' ");
        stringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "show_confirm";
        aVar.sKA.put("show_confirm", "INTEGER");
        stringBuilder.append(" show_confirm INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "use_preset_banner_tips";
        aVar.sKA.put("use_preset_banner_tips", "INTEGER");
        stringBuilder.append(" use_preset_banner_tips INTEGER");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
