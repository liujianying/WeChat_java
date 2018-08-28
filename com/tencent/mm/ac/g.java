package com.tencent.mm.ac;

import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends ab {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.sKA.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "openId";
        aVar.columns[1] = "brandUsername";
        aVar.sKA.put("brandUsername", "TEXT default '' ");
        stringBuilder.append(" brandUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "headImgUrl";
        aVar.sKA.put("headImgUrl", "TEXT");
        stringBuilder.append(" headImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.sKA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "kfType";
        aVar.sKA.put("kfType", "INTEGER");
        stringBuilder.append(" kfType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public g(String str, String str2, String str3, String str4, int i, long j) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i;
        this.field_updateTime = j;
    }
}
