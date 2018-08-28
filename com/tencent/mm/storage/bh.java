package com.tencent.mm.storage;

import com.tencent.mm.g.c.cq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bh extends cq {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tipId";
        aVar.sKA.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "tipId";
        aVar.columns[1] = "tipVersion";
        aVar.sKA.put("tipVersion", "INTEGER");
        stringBuilder.append(" tipVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "tipkey";
        aVar.sKA.put("tipkey", "TEXT");
        stringBuilder.append(" tipkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "tipType";
        aVar.sKA.put("tipType", "INTEGER");
        stringBuilder.append(" tipType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isExit";
        aVar.sKA.put("isExit", "INTEGER");
        stringBuilder.append(" isExit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hadRead";
        aVar.sKA.put("hadRead", "INTEGER");
        stringBuilder.append(" hadRead INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isReject";
        aVar.sKA.put("isReject", "INTEGER");
        stringBuilder.append(" isReject INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "beginShowTime";
        aVar.sKA.put("beginShowTime", "LONG");
        stringBuilder.append(" beginShowTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "disappearTime";
        aVar.sKA.put("disappearTime", "LONG");
        stringBuilder.append(" disappearTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "overdueTime";
        aVar.sKA.put("overdueTime", "LONG");
        stringBuilder.append(" overdueTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "tipsShowInfo";
        aVar.sKA.put("tipsShowInfo", "BLOB");
        stringBuilder.append(" tipsShowInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "extInfo";
        aVar.sKA.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "pagestaytime";
        aVar.sKA.put("pagestaytime", "LONG");
        stringBuilder.append(" pagestaytime LONG");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
