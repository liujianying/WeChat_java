package com.tencent.mm.openim.d;

import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends cu {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.sKA.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "wordingId";
        aVar.sKA.put("wordingId", "TEXT");
        stringBuilder.append(" wordingId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "language";
        aVar.sKA.put("language", "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wording";
        aVar.sKA.put("wording", "TEXT");
        stringBuilder.append(" wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pinyin";
        aVar.sKA.put("pinyin", "TEXT");
        stringBuilder.append(" pinyin TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "quanpin";
        aVar.sKA.put("quanpin", "TEXT");
        stringBuilder.append(" quanpin TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "updateTime";
        aVar.sKA.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
